package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.dtos.FormacionDTO;
import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSailda;
import es.aulanosa.api.repositories.FormacionRepository;
import es.aulanosa.api.services.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    ListaFormacionDTOSailda listarFormacion() {

        return formacionService.listarFormaciones();
    }

    @GetMapping("/api/{idFormacion}/formaciones")
    FormacionDTOSalida obtenerFormacion(@PathVariable int idFormacion) {

        return formacionService.obtenerFormacion(idFormacion);
    }



}
