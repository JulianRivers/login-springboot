package me.julianrivers.login.service.impl;

import me.julianrivers.login.exceptions.AppException;
import me.julianrivers.login.exceptions.ResourceNotFoundException;
import me.julianrivers.login.model.dto.UsuarioDTO;
import me.julianrivers.login.model.entity.UsuarioEntity;
import me.julianrivers.login.repository.UsuarioRepository;
import me.julianrivers.login.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioServiceInterface {
    @Autowired
    UsuarioRepository usuarioRepository;
    /**
     * Crea un usuario en la base de datos
     * @param usuarioDTO UsuarioDTO
     * @return UsuarioDTO
     */
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null){
            throw new AppException(HttpStatus.I_AM_A_TEAPOT, "Usuario ya registrado");
        }
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, usuarioEntity);
        usuarioEntity.setPasswordEncriptada("test:PasswordEncriptada");
        usuarioEntity.setIdUsuario("test:idPublico");
        UsuarioEntity usuarioCreado = usuarioRepository.save(usuarioEntity);
        UsuarioDTO usuarioReturn = new UsuarioDTO();
        BeanUtils.copyProperties(usuarioCreado, usuarioReturn);
        return usuarioReturn;
    }
}
