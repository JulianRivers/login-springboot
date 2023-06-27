package me.julianrivers.login.service.interfaces;

import me.julianrivers.login.model.dto.UsuarioDTO;
import me.julianrivers.login.model.request.UsuarioRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServiceInterface extends UserDetailsService {
    public UsuarioDTO crearUsuario(UsuarioDTO usuario);
}
