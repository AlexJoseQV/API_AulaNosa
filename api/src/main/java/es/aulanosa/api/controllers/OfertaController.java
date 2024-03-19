package es.aulanosa.api.controllers;

import es.aulanosa.api.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * Endpoint que permite obtener toda la información de todas las ofertas
     * @return Se devuelve un listado con la información de todas las ofertas
     */
    @GetMapping("/api/ofertas")
    ResponseEntity<?> obtenerOfertas() {

        return ResponseEntity.ok(ofertaService.listarOfertas());
    }

    /**
     * Endpoint que permite obtener toda la información de una oferta indicada
     * @param idOferta Identificador de la oferta
     * @return Se devuelve la información de la oferta indicada por el identificador
     */
    @GetMapping("/api/ofertas/{idOferta}")
    ResponseEntity<?> devolverOferta(@PathVariable int idOferta) {

        return ResponseEntity.ok(ofertaService.devolverOferta(idOferta));
    }

    /**
     * Endpoint que permite obtener todas las inscripciones asociadas a una oferta concreta
     * @param idOferta Identificador de la oferta
     * @return Se devuelve las inscripciones asociadas a una oferta concreta
     */

    @GetMapping("/api/ofertas/{idOferta}/inscripciones")
    ResponseEntity<?> inscripcionesOferta(@PathVariable int idOferta) {

        return ResponseEntity.ok(ofertaService.obtenerInscripciones(idOferta));
    }
}
