package me.julianrivers.login.service.impl;

import me.julianrivers.login.model.dto.UsuarioDTO;
import me.julianrivers.login.model.request.UsuarioRequest;
import me.julianrivers.login.service.interfaces.UsuarioServiceInterface;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioService implements UsuarioServiceInterface {
    /**
     * Crea un usuario en la base de datos
     * @param usuarioDTO UsuarioDTO
     * @return UsuarioDTO
     */
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        return null;
    }
}
