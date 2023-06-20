package me.julianrivers.login.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private String id;
    private String nombre;
    private String apellido;
    private String email;

}
