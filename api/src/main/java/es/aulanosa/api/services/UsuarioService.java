package es.aulanosa.api.services;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;

/**
 * Interface para establecer los métodos para la comunicación y lógica entre los controladores de Usuarios con la base de datos
 * @author ALEXJOSE
 */
public interface UsuarioService {
    /**
     * Se define un método que permite comprobar el acceso de sesión de un usuario
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    UsuarioDTOSalida comprobarAcceso(AccesoDTO accesoDTO);

    /**
     * Se define un método que permite obtener la información de un usuario a partir de su identificador
     * @param idUsuario Identificador del usuario
     * @return Información del usuario a devolver
     */
    UsuarioDTOSalida devolverUsuario(int idUsuario);
}
