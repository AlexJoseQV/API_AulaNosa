package es.aulanosa.api.controllers;


import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSalida;

import es.aulanosa.api.dtos.*;
import es.aulanosa.api.repositories.FormacionRepository;

import es.aulanosa.api.services.FormacionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



/**
 * controller con los endpoints realcionados con las Formaciones
 */
@RestController
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
     * @param usuarioId id del usuario
     * @return Código de respuesta 200
     */
    @PostMapping("/api/formaciones/{idFormacion}/inscripciones")
    ResponseEntity<?> inscribirUsuario(@PathVariable int idFormacion, @Valid @NotNull @RequestBody int usuarioId){
        return ResponseEntity.ok(formacionService.insribirUsuario(idFormacion,usuarioId,"INSCRITO"));
    }

    /**
     * endpoint para crear una formacion
     * @param formacionDTO formacion a guardar en BD
     * @return devuelve la informacion de la formnacion introducida
     */
    @PostMapping("/api/admin/formaciones")
    FormacionDTOSalida crearFormacion( @RequestBody FormacionDTO formacionDTO){

      return formacionService.crearFormacion(formacionDTO);

    }




}
