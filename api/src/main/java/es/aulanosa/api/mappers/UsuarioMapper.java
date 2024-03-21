package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.UsuarioDTO;
import es.aulanosa.api.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase empleada para el mapeo de objetos correspondientes a la información de un usuario
 * @author ALEXJOSE
 */
public class UsuarioMapper {

    /**
     * Método que permite convertir un UsuarioDTO a un modelo Usuario
     * @param usuarioDTO Información DTO del usuario a convertir
     * @return Se devuelve el modelo del usuario que se ha convertido
     */
    public static Usuario convertirAModel(UsuarioDTO usuarioDTO) {

        return new Usuario(usuarioDTO.getUsuario(), usuarioDTO.getContrasena(), usuarioDTO.getNombre(), usuarioDTO.getApellidos(), usuarioDTO.getEmail(), usuarioDTO.getTelefono(), usuarioDTO.getActualizacion(), usuarioDTO.getEstado(), usuarioDTO.getImagen());
    }

    /**
     * Método que permite convertir un modelo Usuario a UsuarioDTO
     * @param usuario Información del modelo del usuario a convertir
     * @return Se devuelve el DTO del usuario que se ha convertido
     */
    public static UsuarioDTO convertirADTO(Usuario usuario) {

        return new UsuarioDTO(usuario.getId(), usuario.getUsuario(), "", usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getTelefono(), usuario.getActualizacion(), usuario.getEstado(), usuario.getImagen());
    }
    /**
     * Este método permite convertir una lista de usuarios a una lista de usuariosDTO
     * @param usuarioList lista de objetos usuario
     * @return lista de objetos usuarioDTO
     */
    public static List<UsuarioDTO> convertirALista(List<Usuario> usuarioList){
        List<UsuarioDTO> usuarios = new ArrayList<>();
        for (Usuario usuario:usuarioList) {
            usuarios.add(convertirADTO(usuario));
        }

        return usuarios;
    }
}
