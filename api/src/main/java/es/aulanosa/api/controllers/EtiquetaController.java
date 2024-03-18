package es.aulanosa.api.controllers;

import es.aulanosa.api.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
