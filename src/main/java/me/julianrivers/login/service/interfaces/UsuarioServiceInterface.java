package me.julianrivers.login.service.interfaces;

import me.julianrivers.login.model.dto.UsuarioDTO;
import me.julianrivers.login.model.request.UsuarioRequest;

public interface UsuarioServiceInterface {
    public UsuarioDTO crearUsuario(UsuarioDTO usuario);
}
