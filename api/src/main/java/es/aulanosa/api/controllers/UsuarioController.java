package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador con los Endpoints respecto a aspectos de los Usuarios
 * @author ALEXJOSE
 */
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService; // Instancia del servicio del usuario


    /**
     * Endpoint que permite validar si la entrada indicada es correcta para la realización de un inicio de sesión
     * @param acceso Información para realizar el acceso de sesión
     * @return Se devuelve la información crrespondiente al usuario si el inicio es correcto
     */
    @PostMapping("/api/login")
    ResponseEntity<?> iniciarSesion(@RequestBody AccesoDTO acceso) {

        return ResponseEntity.ok(usuarioService.comprobarAcceso(acceso));
    }
}
