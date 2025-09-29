package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Usuario;
import corridabaratas.corridabaratas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public List<Usuario> listarUsuario(){return this.usuarioRepository.findAll();}
}
