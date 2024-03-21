package es.aulanosa.api.services;

import es.aulanosa.api.dtos.EtiquetaDTO;
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

    /**
     * Este método permite registrar una etiqueta a un usuario para saber sus intereses
     * @param id identificador del usuario
     * @param etiquetaDTO identificador de la etiqueta
     * @return Objeto GenericoDTOSalida con la información general
     */
    GenericoDTOSalida crearInteres(int id, EtiquetaDTO etiquetaDTO);

    /**
     * Se define un método empleado para eliminar la relación de una etiqueta con un usuario
     * @param idUsuario Identificador del usuario
     * @param idEtiqueta Identificador de la etiqueta
     * @return Se devuelve un indicador para mostrar si la operación se realizó correctamente
     */
    GenericoDTOSalida eliminarEtiquetaDeUsuario(int idUsuario, int idEtiqueta);
}
