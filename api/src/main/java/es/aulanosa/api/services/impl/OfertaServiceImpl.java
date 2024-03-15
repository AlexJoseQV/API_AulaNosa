package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.ListaOfertaDTOSalida;
import es.aulanosa.api.dtos.OfertaDTO;
import es.aulanosa.api.mappers.OfertaMapper;
import es.aulanosa.api.repositories.OfertaRepository;
import es.aulanosa.api.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase empleada para establecer la comunicación y lógica entre los controladores de las Ofertas con la base de datos
 * @author ALEXJOSE
 */
@Service
public class OfertaServiceImpl implements OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository; // Instancia de la clase repositorio de oferta

    /**
     * Método empleado para obtener todas las ofertas disponibles
     * @return Listado con la información de las ofertas
     */
    @Override
    public ListaOfertaDTOSalida listarOfertas(){
        List<String> errores = new ArrayList<>();
        List<OfertaDTO> ofertasDTO = new ArrayList<>();

        try {
            ofertasDTO = OfertaMapper.convertirListaADTO(ofertaRepository.findAll()); // Se obtiene el listado con toda la información de las ofertas

        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new ListaOfertaDTOSalida(errores, new Timestamp(System.currentTimeMillis()), ofertasDTO);
    }
}
