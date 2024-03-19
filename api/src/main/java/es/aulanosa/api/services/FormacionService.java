package es.aulanosa.api.services;

import es.aulanosa.api.dtos.*;

/**
 * interfaz para los metodos que usara FormacionService
 */
public interface FormacionService {

     ListaFormacionDTOSalida listarFormaciones() ;
     FormacionDTOSalida obtenerFormacion(int idFormacion);
     ListaUsuarioDTOSalida obtenerUsuariosFormacion(int idFormacion);
    /**
     * Método para inscribir un usuario en una formación
     * @param id identificador de una formación
     * @param idUsuario objeto de la clase usuarioDTO
     * @param estado estado de la inscripción
     * @return objeto de la clase GenericoDTOSalida
     */
    GenericoDTOSalida insribirUsuario(int id, int idUsuario,String estado);

}
