package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.UsuarioDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import es.aulanosa.api.services.UsuarioService;
import es.aulanosa.api.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PutMapping("/api/usuarios")
    public UsuarioDTOSalida updateUsuario ( @RequestBody UsuarioDTO usuarioDTO){

        UsuarioDTOSalida usuarioDTOSalida= usuarioService.updateUsuario(usuarioDTO);
        return usuarioDTOSalida;
    }
}
