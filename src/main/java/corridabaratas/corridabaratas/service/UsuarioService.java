package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.dto.request.UsuarioDTOLoginRequest;
import corridabaratas.corridabaratas.dto.request.UsuarioDTORequest;
import corridabaratas.corridabaratas.dto.response.UsuarioDTOLoginResponse;
import corridabaratas.corridabaratas.dto.response.UsuarioDTOResponse;
import corridabaratas.corridabaratas.entity.Role;
import corridabaratas.corridabaratas.entity.RoleName;
import corridabaratas.corridabaratas.entity.Usuario;
import corridabaratas.corridabaratas.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtTokenService jwTokenService;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, JwtTokenService jwTokenService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.jwTokenService = jwTokenService;
    }

    public List<Usuario> listarUsuario(){return this.usuarioRepository.findAll();}

    @Transactional
    public UsuarioDTOResponse criar(UsuarioDTORequest request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setNacionalidade(request.getNacionalidade());
        usuario.setLogin(request.getLogin());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        // give default role
        Role role = new Role();
        role.setName(RoleName.ROLE_USUARIO);
        usuario.setRoles(List.of(role));
        Usuario saved = usuarioRepository.save(usuario);
        return modelMapper.map(saved, UsuarioDTOResponse.class);
    }

    public UsuarioDTOLoginResponse login(UsuarioDTOLoginRequest loginRequest){
        Usuario usuario = usuarioRepository.findByLogin(loginRequest.getLogin())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        // verify password
        if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())){
            throw new RuntimeException("Senha inválida.");
        }
        UsuarioDetailsImpl userDetails = new UsuarioDetailsImpl(usuario);
        String token = jwTokenService.generateToken(userDetails);
        UsuarioDTOLoginResponse resp = new UsuarioDTOLoginResponse();
        resp.setId(usuario.getId());
        resp.setNome(usuario.getNome());
        resp.setToken(token);
        return resp;
    }
}
