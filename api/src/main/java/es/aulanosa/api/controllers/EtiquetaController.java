package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.EtiquetaDTO;
import es.aulanosa.api.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador con los Endpoints relacionados con las etiquetas
 * @author MATHIAS
 */
@RestController
@CrossOrigin
public class EtiquetaController {
    @Autowired
    private EtiquetaService etiquetaService;

    /**
     * Endpoint que permite listar las etiquetas
     * @return Código de respuesta 200 con la lista de etiquetas
     */
    @GetMapping("api/etiquetas")
    ResponseEntity<?> listarEtiquetas(){
        return ResponseEntity.ok(etiquetaService.listarEtiquetas());
    }

    /**
     * Endpoint que permite listar las etiquetas por el identificador del usuario
     * @param id identificador del usuario
     * @return Código de respuesta 200 con la lista de etiquetas filtrada por el identificador del usuario
     */
    @GetMapping("/api/usuarios/{id}/intereses")
    ResponseEntity<?> listarInteresesUsuario(@PathVariable int id){
        return ResponseEntity.ok(etiquetaService.listarInteresesUsuario(id));
    }

    /**
     * Endpoint que permite eliminar las etiquetas de un usuario en específico
     * @param id identificador del usuario
     * @return Código de respuesta 200 con el objeto de la clase GenericoSalidaDTO
     */
    @DeleteMapping("/api/usuarios/{id}/intereses")
    ResponseEntity<?> eliminarInteresesUsuario(@PathVariable int id){
        return ResponseEntity.ok(etiquetaService.eliminarInteresesUsuario(id));
    }

    /**
     * Endpoint que permite registrar una etiqueta a un usuario para saber sus intereses
     * @param idUsuario identificador del usuario
     * @param etiquetaDTO Objeto EtiquetaDTO con la información de la etiqueta
     * @return Código de respuesta 200 con la información general
     */
    @PostMapping("/api/usuarios/{idUsuario}/intereses")
    ResponseEntity<?> insertarIntereses(@PathVariable int idUsuario, @RequestBody EtiquetaDTO etiquetaDTO){
        return ResponseEntity.ok(etiquetaService.crearInteres(idUsuario,etiquetaDTO));
    }
}
