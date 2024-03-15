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
                }
            }else{
                errores.add("Error de acceso");
            }
        }catch (Exception e){
            e.printStackTrace();
            errores.add("Error con la base de datos");
        }

        return new UsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()), usuarioDTO != null ? usuarioDTO : new UsuarioDTO());
    }

    @Override
    public UsuarioDTOSalida updateUsuario(UsuarioDTO usuarioDTO) {

        List<String> errores = new ArrayList<>();
        UsuarioDTOSalida usuarioDTOSalida = new UsuarioDTOSalida();
        Optional<Usuario> usuarioREcuperado = usuarioRepository.findByEmail(usuarioDTO.getUsuario());
        Usuario usuario = usuarioREcuperado.get();
        try{
            if(usuarioREcuperado.isPresent()){


                usuario.setUsuario(usuarioDTO.getUsuario());
                usuario.setNombre(usuarioDTO.getNombre());
                usuario.setApellidos(usuarioDTO.getApellidos());
                usuario.setContrasena(usuarioDTO.getContrasena());
                usuario.setEmail(usuarioDTO.getEmail());
                usuario.setEstado(usuarioDTO.getEstado());
                usuario.setTelefono(usuarioDTO.getTelefono());
                usuario.setActualizacion(new Timestamp(System.currentTimeMillis()));

            }else{
                errores.add("Error de acceso");
            }
        }catch (Exception e){
            e.printStackTrace();
            errores.add("Error con la base de datos");
        }

        return new UsuarioDTOSalida(errores,new Timestamp(System.currentTimeMillis()),UsuarioMapper.convertirADTO(usuario));
    }
}
