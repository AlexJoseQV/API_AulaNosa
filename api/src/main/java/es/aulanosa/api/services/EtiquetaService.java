package es.aulanosa.api.services;

import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;

/**
 * Interface con los métodos que usará EtiquetaService
 * @author MATHIAS
 */
public interface EtiquetaService {
    /**
     * Método que permite listar las etiquetas
     * @return Objeto de la clase ListaEtiquetaDTOSalida con la lista de etiquetas y lista de errores
     */
    ListaEtiquetaDTOSalida listarEtiquetas();
}
