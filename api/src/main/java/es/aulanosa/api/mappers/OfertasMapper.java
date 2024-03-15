package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.OfertasDTO;
import es.aulanosa.api.models.Oferta;


/**
 * Clase empleada para el mapeo de objetos correspondientes a la información de las ofertas
 * @author ALEXJOSE
 */
public class OfertasMapper {

    /**
     * Método que permite convertir un OfertaDTO a un modelo Usuario
     * @param ofertaDTO Información DTO de la oferta a convertir
     * @return Se devuelve el modelo de la oferta que se ha convertido
     */

public static Oferta convertirAModel(OfertasDTO ofertaDTO){

    return new Oferta(ofertaDTO.getId(), ofertaDTO.getTitulo(), ofertaDTO.getDescripcion(), ofertaDTO.getRequisitos(), ofertaDTO.getVacantes(), ofertaDTO.getImagen(), ofertaDTO.getFecha());
}

    /**
     * Método que permite convertir un modelo Oferta a OfertaDTO
     * @param oferta Información del modelo de oferta a convertir
     * @return Se devuelve el DTO de la oferta que se ha convertido
     */

    public static OfertasDTO convertirADTO(Oferta oferta){

        return new OfertasDTO(oferta.getId(),oferta.getTitulo(),oferta.getDescripcion(), oferta.getRequisitos(), oferta.getVacantes(), oferta.getEstado(), oferta.getImagen(), oferta.getFecha());
    }
}