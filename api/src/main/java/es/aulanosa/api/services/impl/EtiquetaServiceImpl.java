package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.mappers.EtiquetaMapper;
import es.aulanosa.api.repositories.EtiquetaRepository;
import es.aulanosa.api.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene métodos para las etiquetas
 * @author MATHIAS
 */
@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     * Este método permite listar las etiquetas
     * @return objeto listaEtiquetaDTOSalida
     */
    @Override
    public ListaEtiquetaDTOSalida listarEtiquetas() {
        List<String> errores = new ArrayList<>();
        try {
            return new ListaEtiquetaDTOSalida(EtiquetaMapper.convertirALista(etiquetaRepository.findAll()),errores, new Timestamp(System.currentTimeMillis()));
        }catch (Exception e){
            errores.add("Hubo un error");
        }

        return new ListaEtiquetaDTOSalida(new ArrayList<>(),errores,new Timestamp(System.currentTimeMillis()));

    }

    @Override
    public ListaEtiquetaDTOSalida listarInteresesUsuario(int id) {
        List<String> errores = new ArrayList<>();
        try {
            return new ListaEtiquetaDTOSalida(EtiquetaMapper.convertirALista(etiquetaRepository.findById(id)),errores, new Timestamp(System.currentTimeMillis()));
        }catch (Exception e){
            errores.add("Hubo un error");
        }

        return new ListaEtiquetaDTOSalida(new ArrayList<>(),errores,new Timestamp(System.currentTimeMillis()));
    }
}
