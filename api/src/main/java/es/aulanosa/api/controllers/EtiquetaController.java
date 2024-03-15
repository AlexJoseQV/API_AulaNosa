package es.aulanosa.api.controllers;

import es.aulanosa.api.services.EtiquetaService;
import es.aulanosa.api.services.impl.EtiquetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtiquetaController {
    private EtiquetaService etiquetaService;
    @GetMapping("api/etiquetas")
    ResponseEntity<?> listarEtiquetas(){
        etiquetaService = new EtiquetaServiceImpl();
        return ResponseEntity.ok(etiquetaService.listarEtiquetas());
    }
}
