package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSalida;
import es.aulanosa.api.services.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * controller con los endpoints realcionados con las Formaciones
 */
@RestController
@Validated
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



}
