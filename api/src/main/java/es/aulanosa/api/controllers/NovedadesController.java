package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.NovedadDTO;
import es.aulanosa.api.services.EtiquetaService;
import es.aulanosa.api.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador con los Endpoints relacionados con las novedades (ofertas + formaciones)
 * @author Martin
 */
@RestController
@CrossOrigin
public class NovedadesController {

    @Autowired
    private OfertaService ofertasService;
//    private FormacionesService formacionesService;

    /**
     * Endpoint que permite listar las novedades
     * @return Código de respuesta 200 con la lista de novedades
     */
    @GetMapping("api/novedades")
    ResponseEntity<?> listarNovedades(){

        return ResponseEntity.ok(new NovedadDTO(ofertasService.listarOfertas()));
        // Se añadira la lista de formaciones una vez este lista
    }
}