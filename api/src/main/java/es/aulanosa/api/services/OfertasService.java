package es.aulanosa.api.services;

import es.aulanosa.api.dtos.OfertasDTO;

import java.util.List;

/**
 * Interface para establecer los métodos para la comunicación y lógica entre los controladores de Oferta con la base de datos
 * @author RubénC
 */

public interface OfertasService {
    List<OfertasDTO> obtenerListaOfertas();

    void crearOfertaDTO(OfertasDTO ofertaDTO);

    void modificarOfertaDTO(OfertasDTO ofertaDTO);
}
