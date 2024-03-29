package es.aulanosa.api.controllers;


import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSalida;

import es.aulanosa.api.dtos.*;

import es.aulanosa.api.services.FormacionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



/**
 * controller con los endpoints realcionados con las Formaciones
 */
@RestController
@CrossOrigin
public class FormacionController {

    @Autowired
    private FormacionService formacionService;

    /**
     * endpoint de listar formaciones
     * @return devuelve FormacionDTOSalida (lista de formaciones)
     */
    @GetMapping("/api/formaciones")
    ListaFormacionDTOSalida listarFormacion() {

        return formacionService.listarFormaciones();
    }

    /**
     * endpoint para obtener una formacion por su id
     * @param idFormacion id de busqueda de la formacion
     * @return formacionDTOSalida encontrdda en la bd por ese id
     */
    @GetMapping("/api/{idFormacion}/formaciones")
    FormacionDTOSalida obtenerFormacion(@PathVariable int idFormacion) {

        return formacionService.obtenerFormacion(idFormacion);
    }

    /**
     * endpoint para obtener los usuarios incritos en una formacion
     * @param idFormacion id de la formacion
     * @return lista de usuarios inscritos
     */
    @GetMapping("/api/formaciones/{idFormacion}/inscripciones")
    ListaUsuarioDTOSalida listarUsuariosIncritos(@PathVariable int idFormacion){

        return formacionService.obtenerUsuariosFormacion(idFormacion);

    }

    /**
     * Endpoint para inscribir un usuario en una formación
     * @param idFormacion identificador de la formación
     * @param inscripcionUsuarioDTO Información con el identificador del usuario para la inscripción
     * @return Código de respuesta 200
     */
    @PostMapping("/api/formaciones/{idFormacion}/inscripciones")
    GenericoDTOSalida inscribirUsuario(@PathVariable int idFormacion, @Valid @RequestBody InscripcionUsuarioDTO inscripcionUsuarioDTO){
        return formacionService.insribirUsuario(idFormacion,inscripcionUsuarioDTO.getUsuarioId(),"INSCRITO");
    }

    /**
     * endpoint para crear una formacion
     * @param formacionDTO formacion a guardar en BD
     * @return devuelve la informacion de la formnacion introducida
     */
    @PostMapping("/api/admin/formaciones")
    FormacionDTOSalida crearFormacion( @RequestBody @Valid FormacionDTO formacionDTO){

      return formacionService.crearFormacion(formacionDTO);

    }

    /**
     * Endpoint que permite quitar un usuario de una formación
     * @param idUsuario identificador del usuario
     * @param formacionId identificador de la formación
     * @return Código de respuesta 200 con la información general por si hubo un error
     */
    @Transactional
    @DeleteMapping("/api/{idUsuario}/eliminarUsuarioFormacion")
    ResponseEntity<?> eliminarUsuarioFormacion(@PathVariable int idUsuario, @RequestBody int formacionId){
        return ResponseEntity.ok(formacionService.eliminarUsuarioFormacion(idUsuario,formacionId));
    }

    @GetMapping("/api/formaciones/{idUsuario}/usuarios")
    ListaFormacionUsuarioDTOSalida listarFormacionesUsuarios(@PathVariable int idUsuario){

        return formacionService.listarFormacionesUsuario(idUsuario);

    }

}
