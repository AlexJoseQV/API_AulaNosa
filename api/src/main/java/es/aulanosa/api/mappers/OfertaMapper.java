package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.OfertaDTO;
import es.aulanosa.api.models.Oferta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase empleada para el mapeo de objetos correspondientes a la información de Oferta
 * @author ALEXJOSE
 */
public class OfertaMapper {

    /**
     * Método que permite convertir un OfertaDTO a un modelo Oferta
     * @param ofertaDTO Información DTO de la oferta a convertir
     * @return Se devuelve el modelo de oferta que se ha convertido
     */
    public static Oferta convertirAModel(OfertaDTO ofertaDTO) {

        // Mapeo del Array de requisitos a String
        StringBuilder requisitos = new StringBuilder();
        for(int i = 0; i<ofertaDTO.getRequisitos().size(); i++){
            requisitos.append(ofertaDTO.getRequisitos()).append("$$");
        }


        return new Oferta(ofertaDTO.getVacantes(), ofertaDTO.getTitulo(), ofertaDTO.getEstado(), ofertaDTO.getDescripcion(), ofertaDTO.getFecha(), requisitos.toString(), ofertaDTO.getImagen());
    }

    /**
     * Método que permite convertir un modelo Oferta a OfertaDTO
     * @param oferta Información del modelo del oferta a convertir
     * @return Se devuelve el DTO de la oferta que se ha convertido
     */
    public static OfertaDTO convertirADTO(Oferta oferta) {

        // Mapeo de los requisitos de String a Array
        List<String> requisitos = new ArrayList<>();
        if (oferta.getRequisitos() != null && !oferta.getRequisitos().isEmpty()) {
            Collections.addAll(requisitos, oferta.getRequisitos().split("\\$\\$"));
        }

        return new OfertaDTO(oferta.getId(), oferta.getVacantes(), oferta.getTitulo(), oferta.getEstado(), oferta.getDescripcion(), oferta.getFecha(), requisitos, oferta.getImagen());
    }

    /**
     * Método que permite convertir un listado de modelos Oferta a un listado de OfertaDTO
     * @param ofertas Listado de modelos Oferta
     * @return Se devuelve un listado de DTO de ofertas
     */
    public static List<OfertaDTO> convertirListaADTO(List<Oferta> ofertas){
        List<OfertaDTO> ofertasDTO = new ArrayList<>();
        for (Oferta oferta : ofertas) {
            List<String> requisitos = new ArrayList<>();
            if (oferta.getRequisitos() != null && !oferta.getRequisitos().isEmpty()) {
                Collections.addAll(requisitos, oferta.getRequisitos().split("\\$\\$"));
            }
            ofertasDTO.add(new OfertaDTO(oferta.getId(), oferta.getVacantes(), oferta.getTitulo(), oferta.getEstado(), oferta.getDescripcion(), oferta.getFecha(), requisitos, oferta.getImagen()));
        }

        return ofertasDTO;
    }
}
