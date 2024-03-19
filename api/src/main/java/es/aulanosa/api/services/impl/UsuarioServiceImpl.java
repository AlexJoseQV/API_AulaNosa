package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.dtos.UsuarioDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import es.aulanosa.api.mappers.UsuarioMapper;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.repositories.UsuarioRepository;
import es.aulanosa.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase empleada para establecer la comunicación y lógica entre los controladores de los Usuarios con la base de datos
 * @author ALEXJOSE
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository; // Instancia de la clase repositorio del usuario

    /**
     * Método que permite comprobar el acceso de sesión de un usuario
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    @Override
    public UsuarioDTOSalida comprobarAcceso(AccesoDTO accesoDTO){
        List<String> errores = new ArrayList<>();
        UsuarioDTO usuarioDTO = null;
        try{
            // Obtener el usuario por correo electrónico
            Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(accesoDTO.getNombre());

            if(usuarioOpt.isPresent()){
                Usuario usuario = usuarioOpt.get();

                // Comprobar si las contraseñas coinciden
                if (usuario.getContrasena().equals(accesoDTO.getContrasena())) {
                    // Contraseña correcta, convertir Usuario a UsuarioDTOSalida
                    usuarioDTO = UsuarioMapper.convertirADTO(usuario);
                }else{
                    errores.add("Error de contrasena");
                }
            }else{
                errores.add("Error email no existe");
            }
        }catch (Exception e){
            e.printStackTrace();
            errores.add("Error con la base de datos");
        }

        return new UsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()), usuarioDTO != null ? usuarioDTO : new UsuarioDTO());
    }

    /**
     * Método que permite obtener la información de un usuario a partir de su identificador
     * @param idUsuario Identificador del usuario
     * @return Información del usuario a devolver
     */
    @Override
    public UsuarioDTOSalida devolverUsuario(int idUsuario){
        List<String> errores = new ArrayList<>();
        UsuarioDTO usuarioDTO = null;

        try {
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario); // Se busca por id un usuario
            if(usuarioOpt.isPresent()){
                usuarioDTO = UsuarioMapper.convertirADTO(usuarioOpt.get());
            }else{
                errores.add("Error el usuario no existe");
            }
        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new UsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()), usuarioDTO != null ? usuarioDTO : new UsuarioDTO());
    }

    /**
     * Método que permite registrar un usuario a partir de la información indicada
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información correspondiente al usuario posteriormente al registro
     */
    @Override
    public UsuarioDTOSalida crearUsuario(UsuarioDTO usuarioDTO){

        List<String> errores = new ArrayList<>(); // Mensajes de errores
        Usuario usuarioDevolver = null;

        try {
            // Validación de la existencia previa de si el usuario ya está registrado y del email seleccionado
            Optional<Usuario> usuarioOptEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
            Optional<Usuario> usuarioOptUsuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
            if(usuarioOptEmail.isPresent()) errores.add("Error el usuario ya existe");
            if(usuarioOptUsuario.isPresent()) errores.add("Error el email ya está en uso");

            if(errores.isEmpty()){
                usuarioDTO.setActualizacion(new Timestamp(System.currentTimeMillis()));
                usuarioDevolver = usuarioRepository.save(UsuarioMapper.convertirAModel(usuarioDTO));
            }
        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new UsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()), usuarioDevolver != null ? UsuarioMapper.convertirADTO(usuarioDevolver) : new UsuarioDTO());
    }
}
