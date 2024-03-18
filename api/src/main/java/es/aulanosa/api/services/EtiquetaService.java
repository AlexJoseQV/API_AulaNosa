package es.aulanosa.api.services;

import es.aulanosa.api.dtos.GenericoDTOSalida;
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

    /**
     * Método que permite listar las etiquetas por el identificador de usuario
     * @param id identificador del usuario
     * @return Objeto de la clase ListaEtiquetaDTOSalida con la lista de etiquetas y lista de errores
     */
    ListaEtiquetaDTOSalida listarInteresesUsuario(int id);

    /**
     * Método que permite eliminar las etiquetas de un usuario
     * @param id identificador del usuario
     * @return Objeto de la clase GenericoDTOSalida con la información genérica
     */
    GenericoDTOSalida eliminarInteresesUsuario(int id);
}
