package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.EtiquetaDTO;
import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.models.Etiqueta;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza los cambios entre lista de etiquetas y lista de etiquetasDTO
 * y de etiqueta a etiquetaDTO
 * @author MATHIAS
 */
public class EtiquetaMapper {

    /**
     * Este método permite convertir una lista de etiquetas a una lista de etiquetasDTO
     * @param etiquetaList lista de objetos etiqueta
     * @return lista de objetos etiquetaDTO
     */
    public static List<EtiquetaDTO> convertirALista(List<Etiqueta> etiquetaList){
        List<EtiquetaDTO> etiquetas = new ArrayList<>();
        for (Etiqueta etiqueta:etiquetaList) {
            etiquetas.add(convertirADTO(etiqueta));
        }

        return etiquetas;
    }

    /**
     * Este método permite convertir una etiqueta a una etiquetaDTO
     * @param etiqueta
     * @return
     */
    public static EtiquetaDTO convertirADTO(Etiqueta etiqueta){
        return new EtiquetaDTO(etiqueta.getId(), etiqueta.getNombre());
    }

    public static Etiqueta convertirAModelo(EtiquetaDTO etiquetaDTO){

        return new Etiqueta(etiquetaDTO.getId(), etiquetaDTO.getNombre());
    }
}
