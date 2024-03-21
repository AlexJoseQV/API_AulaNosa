package es.aulanosa.api.services;

import es.aulanosa.api.dtos.*;

/**
 * Interface para establecer los métodos para la comunicación y lógica entre los controladores de Ofertas con la base de datos
 * @author ALEXJOSE
 */
public interface OfertaService {


    /**
     * Se define un método empleado para obtener todas las ofertas disponibles
     * @return Listado con la información de las ofertas
     */
    ListaOfertaDTOSalida listarOfertas();

    /**
     * Se define un método empleado para obtener la información de una oferta en base a indicarle el identificador de la oferta
     * @param idOferta Identificador de la oferta
     * @return Se devuelve la información de la oferta indicada
     */
    OfertaDTOSalida devolverOferta(int idOferta);

    ListaUsuarioDTOSalida listarUsuariosOferta(int idOferta);

    /**
     * Este método permite crear una oferta
     * @param ofertaDTO objeto de la clase OfertaDTO
     * @return objeto de la clase OfertaDTOSalida
     */
    OfertaDTOSalida crearOferta(OfertaDTO ofertaDTO);
    /**
     * Método para inscribir un usuario en una oferta
     * @param idUsuario objeto de la clase usuarioDTO
     * @param idOferta identificador de una oferta
     * @param estado estado de la oferta
     * @return objeto de la clase GenericoDTOSalida
     */
    GenericoDTOSalida insribirUsuario(int idUsuario,int idOferta,String estado);

    ListaOfertaUsuarioDTOSalida listarOfertaUsuario(int idUsuario);
}
