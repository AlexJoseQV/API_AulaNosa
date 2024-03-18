package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.ListaFormacionDTOSalida;
import es.aulanosa.api.services.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
