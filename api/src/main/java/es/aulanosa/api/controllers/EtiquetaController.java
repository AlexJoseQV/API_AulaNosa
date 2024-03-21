package es.aulanosa.api.controllers;

import es.aulanosa.api.dtos.EtiquetaDTO;
import es.aulanosa.api.dtos.GenericoDTOSalida;
import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.services.EtiquetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/api/etiquetas")
    ListaEtiquetaDTOSalida listarEtiquetas(){
        return etiquetaService.listarEtiquetas();
    }

    /**
     * Endpoint que permite listar las etiquetas por el identificador del usuario
     * @param id identificador del usuario
     * @return Código de respuesta 200 con la lista de etiquetas filtrada por el identificador del usuario
     */
    @GetMapping("/api/usuarios/{id}/intereses")
    ListaEtiquetaDTOSalida listarInteresesUsuario(@PathVariable int id){
        return etiquetaService.listarInteresesUsuario(id);
    }

    /**
     * Endpoint que permite eliminar las etiquetas de un usuario en específico
     * @param id identificador del usuario
     * @return Código de respuesta 200 con el objeto de la clase GenericoSalidaDTO
     */
    @DeleteMapping("/api/usuarios/{id}/intereses")
    GenericoDTOSalida eliminarInteresesUsuario(@PathVariable int id){
        return etiquetaService.eliminarInteresesUsuario(id);
    }

    /**
     * Endpoint que permite registrar una etiqueta a un usuario para saber sus intereses
     * @param idUsuario identificador del usuario
     * @param etiquetaDTO Objeto EtiquetaDTO con la información de la etiqueta
     * @return Código de respuesta 200 con la información general
     */
    @PostMapping("/api/usuarios/{idUsuario}/intereses")
    GenericoDTOSalida insertarIntereses(@PathVariable int idUsuario, @Valid @RequestBody EtiquetaDTO etiquetaDTO){
        return etiquetaService.crearInteres(idUsuario,etiquetaDTO);
    }

    /**
     * Endpoint que permite eliminar una relación entre un usuario con respecto a una etiqueta
     * @param idUsuario Identificador del usuario
     * @param etiquetaDTO Información con el identificador de la etiqueta
     * @return Se devuelve un indicador que muestra el resultado de la operación realizada
     */
    @DeleteMapping("/api/usuarios/{idUsuario}/etiqueta")
    GenericoDTOSalida eliminarInteresesUsuario(@PathVariable int idUsuario, @Valid @RequestBody EtiquetaDTO etiquetaDTO){
        return etiquetaService.eliminarEtiquetaDeUsuario(idUsuario, etiquetaDTO.getId());
    }
}
