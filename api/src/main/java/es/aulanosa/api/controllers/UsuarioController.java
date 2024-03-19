package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.dtos.UsuarioDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import es.aulanosa.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Controlador con los Endpoints respecto a aspectos de los Usuarios
 * @author ALEXJOSE
 */
@RestController
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService; // Instancia del servicio del usuario


    /**
     * Endpoint que permite validar si la entrada indicada es correcta para la realización de un inicio de sesión
     * @param acceso Información para realizar el acceso de sesión
     * @return Se devuelve la información correspondiente al usuario si el inicio es correcto
     */
    @PostMapping("/api/login")
    ResponseEntity<?> iniciarSesion(@Valid @RequestBody AccesoDTO acceso) {

        return ResponseEntity.ok(usuarioService.comprobarAcceso(acceso));
    }

    /**
     * Endpoint que permite devolver la información de un usuario a partir de un identificador indicado
     * @param idUsuario Identificador del usuario
     * @return Se devuelve la información del usuario indicado
     */
    @GetMapping("/api/usuarios/{idUsuario}")
    ResponseEntity<?> obtenerUsuario(@PathVariable int idUsuario) {

        return ResponseEntity.ok(usuarioService.devolverUsuario(idUsuario));
    }

    /**
     * Endpoint que permite devolver la información de un usuario a partir de un identificadro indicado
     * @param nombreUsuario Nombre del usuario
     * @return Se devuelve la información del usuario indicado
     */
    @GetMapping("/api/usuarios/{nombreUsuario}")
    ResponseEntity<?> obtenerUsuario(@PathVariable String nombreUsuario){

        return ResponseEntity.ok(usuarioService.encontrarUsuario(nombreUsuario));
    }

    /**
     * Endpoint que permite registrar la información correspondiente a un usuario
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información posterior al registro
     */
    @PostMapping("/api/admin/usuarios")
    ResponseEntity<?> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {

        return ResponseEntity.ok(usuarioService.crearUsuario(usuarioDTO));
    }

}
