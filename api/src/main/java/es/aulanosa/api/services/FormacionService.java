package es.aulanosa.api.services;


import es.aulanosa.api.dtos.*;
import es.aulanosa.api.dtos.FormacionDTO;
import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSalida;
import es.aulanosa.api.dtos.ListaUsuarioDTOSalida;


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
    FormacionDTOSalida crearFormacion(FormacionDTO formacionDTO);

    /**
     * Este método permite quitar a un usuario de una formación
     * @param idUsuario identificador del usuario
     * @param formacionId identificador de la formación
     * @return Objeto de la clase GenericoDTOSalida con la información general de un error
     */
    GenericoDTOSalida eliminarUsuarioFormacion(int idUsuario, int formacionId);


}
