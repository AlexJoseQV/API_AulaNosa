package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("api/login")
    ResponseEntity<?> iniciarSesion(@RequestBody AccesoDTO acceso) {

        return ResponseEntity.ok(usuarioService.comprobarAcceso(acceso));
    }
}
