package corridabaratas.corridabaratas.service;

import corridabaratas.corridabaratas.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UsuarioDetailsImpl implements UserDetails {
    private final Usuario usuario;

    public UsuarioDetailsImpl(Usuario usuario){
        this.usuario = usuario;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        // Project does not store passwords in this minimal demo; return null to indicate not used
        return null;
    }

    @Override
    public String getUsername() {
        // Return the usuario id as subject for tokens when requested by the app
        return usuario.getId() != null ? usuario.getId().toString() : null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getIdUsuario(){
        return usuario.getId();
    }

    public String getNomeUsuario(){
        return usuario.getNome();
    }
}

