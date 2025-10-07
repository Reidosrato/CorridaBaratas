package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Usuario;
import corridabaratas.corridabaratas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// The application uses user id as token subject; try to parse as id first
		try {
			Integer id = Integer.parseInt(username);
			Optional<Usuario> usuario = usuarioRepository.findById(id);
			Usuario u = usuario.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
			return new UsuarioDetailsImpl(u);
		} catch (NumberFormatException ex) {
			// fallback: try to find by login (username)
			Usuario usuario = usuarioRepository.findByLogin(username)
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
			return new UsuarioDetailsImpl(usuario);
		}
	}
}
