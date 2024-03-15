package es.aulanosa.api.controllers;

import es.aulanosa.api.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador con los Endpoints respecto a aspectos de las Ofertas
 * @author ALEXJOSE
 */
@RestController
@CrossOrigin
public class OfertaController {

    @Autowired
    private OfertaService ofertaService; // Instancia del servicio de Oferta

    /**
     * Endpoint que permite obtener todas la información de todas las ofertas
     * @return Se devuelve un listado con la información de todas las ofertas
     */
    @GetMapping("/api/ofertas")
    ResponseEntity<?> obtenerUsuario() {

        return ResponseEntity.ok(ofertaService.listarOfertas());
    }
}
