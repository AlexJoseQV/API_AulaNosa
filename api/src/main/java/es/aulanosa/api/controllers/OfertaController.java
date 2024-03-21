package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.*;
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
    ListaOfertaDTOSalida obtenerOfertas() {

        return ofertaService.listarOfertas();
    }

    /**
     * Endpoint que permite obtener toda la información de una oferta indicada
     * @param idOferta Identificador de la oferta
     * @return Se devuelve la información de la oferta indicada por el identificador
     */
    @GetMapping("/api/ofertas/{idOferta}")
    OfertaDTOSalida devolverOferta(@PathVariable int idOferta) {

        return ofertaService.devolverOferta(idOferta);
    }

    /**
     * Endpoint que permite obtener toda la información de los usuarios inscritos en una oferta indicada
     * @param idOferta Identificador de la oferta
     * @return Se devuelve un listado con la información de los usuarios inscritos en dicha oferta
     */
    @GetMapping("/api/ofertas/{idOferta}/inscripciones")
    ListaUsuarioDTOSalida devolverUsuariosInscritos(@PathVariable int idOferta) {

        return ofertaService.listarUsuariosOferta(idOferta);
    }

    /**
     * Endpoint que permite crear una oferta
     * @param ofertaDTO objeto de la clase OfertaDTO
     * @return Código de respuesta 200
     */
    @PostMapping("/api/admin/ofertas")
    OfertaDTOSalida crearOfertas(@RequestBody @Valid OfertaDTO ofertaDTO){
        return ofertaService.crearOferta(ofertaDTO);
    }

    /**
     * Endpoint para inscribir un usuario en una oferta
     * @param idOferta identificador de la oferta
     * @param inscripcionUsuarioDTO Objeto con el identificador del usuario para la inscripción
     * @return Código de respuesta 200
     */
    @PostMapping("/api/ofertas/{idOferta}/inscripciones")
    GenericoDTOSalida inscribirUsuario(@PathVariable int idOferta, @Valid @RequestBody InscripcionUsuarioDTO inscripcionUsuarioDTO){
        return ofertaService.insribirUsuario(inscripcionUsuarioDTO.getUsuarioId(),idOferta,"INSCRITO");
    }

    /**
     * Endpoint para eliminar una relación entre un usuario con respecto a una oferta
     * @param idUsuario Identificador del usuario
     * @param idOferta Identificador de la oferta
     * @return Se devuelve un indicador con respecto al estado de la operación realizada
     */
    @DeleteMapping("/api/usuarios/{idUsuario}/oferta/{idOferta}")
    GenericoDTOSalida eliminarOfertaUsuario(@PathVariable int idUsuario, @PathVariable int idOferta){
        return ofertaService.eliminarOfertaDeUsuario(idUsuario, idOferta);
    }

    @GetMapping("/api/ofertas/{idUsuario}/usuarios")
    ListaOfertaUsuarioDTOSalida listarOfertaUsuarios(@PathVariable int idUsuario){

        return ofertaService.listarOfertaUsuario(idUsuario);

    }
}
