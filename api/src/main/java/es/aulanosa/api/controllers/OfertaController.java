package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.OfertaDTO;
import es.aulanosa.api.services.OfertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * Endpoint que permite obtener toda la información de los usuarios inscritos en una oferta indicada
     * @param idOferta Identificador de la oferta
     * @return Se devuelve un listado con la información de los usuarios inscritos en dicha oferta
     */
    @GetMapping("/api/ofertas/{idOferta}/inscripciones")
    ResponseEntity<?> devolverUsuariosInscritos(@PathVariable int idOferta) {

        return ResponseEntity.ok(ofertaService.listarUsuariosOferta(idOferta));
    }

    /**
     * Endpoint que permite crear una oferta
     * @param ofertaDTO objeto de la clase OfertaDTO
     * @return Código de respuesta 200
     */
    @PostMapping("/api/admin/ofertas")
    ResponseEntity<?> crearOfertas(@RequestBody @Valid OfertaDTO ofertaDTO){
        return ResponseEntity.ok(ofertaService.crearOferta(ofertaDTO));
    }
}
