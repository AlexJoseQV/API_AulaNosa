package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.EtiquetaDTO;
import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.models.Etiqueta;

import java.util.ArrayList;
import java.util.List;

public class EtiquetaMapper {
    public static ListaEtiquetaDTOSalida convertirAListaEtiquetaDTOSalida(List<Etiqueta> etiquetaList){
        ListaEtiquetaDTOSalida listaEtiquetaDTOSalida = new ListaEtiquetaDTOSalida();
        List<EtiquetaDTO> etiquetas = new ArrayList<>();
        for (Etiqueta etiqueta:etiquetaList) {
            etiquetas.add(convertirADTO(etiqueta));
        }
        listaEtiquetaDTOSalida.setEtiquetas(etiquetas);
        return listaEtiquetaDTOSalida;
    }

    public static List<EtiquetaDTO> convertirALista(List<Etiqueta> etiquetaList){
        List<EtiquetaDTO> etiquetas = new ArrayList<>();
        for (Etiqueta etiqueta:etiquetaList) {
            etiquetas.add(convertirADTO(etiqueta));
        }

        return etiquetas;
    }

    public static EtiquetaDTO convertirADTO(Etiqueta etiqueta){
        return new EtiquetaDTO(etiqueta.getId(), etiqueta.getNombre());
    }
}
