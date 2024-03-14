package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.mappers.EtiquetaMapper;
import es.aulanosa.api.repositories.EtiquetaRepository;
import es.aulanosa.api.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EtiquetaServiceImpl implements EtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;
    @Override
    public ListaEtiquetaDTOSalida listarEtiquetas() {
        List<String> errores = new ArrayList<>();
        
        try {
            return new ListaEtiquetaDTOSalida(EtiquetaMapper.convertirALista(etiquetaRepository.findAll()),errores, null);
        }catch (Exception e){
            errores.add("Hubo un error");
        }

        return new ListaEtiquetaDTOSalida(null,errores,new Timestamp(System.currentTimeMillis()));

    }
}
