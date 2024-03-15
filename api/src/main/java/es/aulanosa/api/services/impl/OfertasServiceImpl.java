package es.aulanosa.api.services.impl;

import es.aulanosa.api.repositories.EtiquetaRepository;
import es.aulanosa.api.services.OfertasService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OfertasServiceImpl implements OfertasService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     * Este método permite listar las ofertas
     * @return objeto listaOfertasDTOSalida
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


}
