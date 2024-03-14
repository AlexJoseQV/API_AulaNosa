package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.UsuarioDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UsuarioController {

    @RequestMapping(method = RequestMethod.PUT)
    public UsuarioDTOSalida updateUsuario (UsuarioDTO usuarioDTO){


    }
}
