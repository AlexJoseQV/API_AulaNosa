package es.aulanosa.api.services;

import es.aulanosa.api.dtos.ListaOfertaDTOSalida;
import es.aulanosa.api.dtos.OfertaDTOSalida;

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
}
