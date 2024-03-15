package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.UsuarioDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import es.aulanosa.api.services.UsuarioService;
import es.aulanosa.api.services.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UsuarioController {

    @PutMapping("/api/usuarios")
    public UsuarioDTOSalida updateUsuario (UsuarioDTO usuarioDTO){

        UsuarioService us = new UsuarioServiceImpl();

        return us.updateUsuario(usuarioDTO);
    }
}
