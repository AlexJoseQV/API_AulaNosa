package es.aulanosa.api.services;

import es.aulanosa.api.dtos.OfertaDTO;

import java.util.List;

/**
 * Interface para establecer los métodos para la comunicación y lógica entre los controladores de Oferta con la base de datos
 * @author RubénC
 */

public interface OfertaService {
    List<OfertaDTO> obtenerListaOfertas();

    void crearOfertaDTO(OfertaDTO ofertaDTO);

    void modificarOfertaDTO(OfertaDTO ofertaDTO);
}
