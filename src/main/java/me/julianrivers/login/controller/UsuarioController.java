package me.julianrivers.login.controller;

import me.julianrivers.login.model.dto.UsuarioDTO;
import me.julianrivers.login.model.request.UsuarioRequest;
import me.julianrivers.login.model.response.UsuarioResponse;
import me.julianrivers.login.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceInterface usuarioService;

    @GetMapping()
    public String getUsuario(){
        return "hola";
    }

    @PostMapping
    public UsuarioResponse crearUsuario(@RequestBody UsuarioRequest usuario){
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuario, usuarioDTO);

        UsuarioDTO usuarioCreado = usuarioService.crearUsuario(usuarioDTO);
        BeanUtils.copyProperties(usuarioCreado, usuarioResponse);
        return usuarioResponse;
    }

}
