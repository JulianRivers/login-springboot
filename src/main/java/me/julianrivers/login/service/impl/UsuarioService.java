package me.julianrivers.login.service.impl;

import me.julianrivers.login.exceptions.AppException;
import me.julianrivers.login.model.dto.UsuarioDTO;
import me.julianrivers.login.model.entity.UsuarioEntity;
import me.julianrivers.login.repository.UsuarioRepository;
import me.julianrivers.login.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService implements UsuarioServiceInterface {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * Crea un usuario en la base de datos
     * @param usuarioDTO UsuarioDTO
     * @return UsuarioDTO
     */
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null){
            throw new AppException(HttpStatus.BAD_REQUEST, "Usuario ya registrado");
        }
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, usuarioEntity);

        usuarioEntity.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioDTO.getPassword()));//encriptar contraseña
        UUID uuid = UUID.randomUUID();//genera un ID público
        usuarioEntity.setIdUsuario(uuid.toString());
        UsuarioEntity usuarioCreado = usuarioRepository.save(usuarioEntity);
        UsuarioDTO usuarioReturn = new UsuarioDTO();
        BeanUtils.copyProperties(usuarioCreado, usuarioReturn);
        return usuarioReturn;
    }

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
