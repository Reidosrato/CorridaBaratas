package corridabaratas.corridabaratas.config;

import corridabaratas.corridabaratas.entity.Usuario;
import corridabaratas.corridabaratas.repository.UsuarioRepository;
import corridabaratas.corridabaratas.service.JwtTokenService;
import corridabaratas.corridabaratas.service.UsuarioDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.yaml.snakeyaml.events.Event;

import java.io.IOException;
import java.util.Arrays;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenService jwTokenService; // Service que definimos anteriormente
    @Autowired
    private UsuarioRepository usuarioRepository; // Repository que definimos anteriormente
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Verifica se o endpoint requer autenticação antes de processar a requisição
        if (checkIfEndpointIsNotPublic(request)) {
            String token = recoveryToken(request); // Recupera o token do cabeçalho Authorization da requisição
            if (token != null) {
                    String subject = jwTokenService.getSubjectFromToken(token); // subject is usuario id (string)
                    Integer usuarioId = null;
                    try {
                        usuarioId = Integer.parseInt(subject);
                    } catch (NumberFormatException ex) {
                        throw new RuntimeException("Token com subject inválido.");
                    }

                    Usuario usuario = usuarioRepository.findById(usuarioId)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado pelo id no token."));

                    UsuarioDetailsImpl userDetails = new UsuarioDetailsImpl(usuario);

                    // Create authentication object using userDetails' authorities
                    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new RuntimeException("O token está ausente.");
            }
        }
        filterChain.doFilter(request, response); // Continua o processamento da requisição
    }

    // Recupera o token do cabeçalho Authorization da requisição
    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    // Verifica se o endpoint requer autenticação antes de processar a requisição
    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        //ajustado para funcionamento do swagger
        String requestURI = request.getRequestURI();
        return Arrays.stream(SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).noneMatch(publicEndpoint ->
                requestURI.startsWith(publicEndpoint.replace("/**", "")) // suporta wildcard
        );
    }

}