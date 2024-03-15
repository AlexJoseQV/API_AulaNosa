package es.aulanosa.api;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.repositories.UsuarioRepository;
import es.aulanosa.api.services.UsuarioService;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clase empleada para la realización de pruebas con el service de Usuario
 * @author ALEXJOSE
 */
@SpringBootTest
public class UsuarioServiceTests {
    @Autowired
    private UsuarioRepository usuarioRepository; // Instancia de la clase repositorio del usuario
    @Autowired
    private UsuarioService usuarioService; // Instancia del servicio del usuario

    /**
     * Caso de prueba para comprobar el acceso correcto de un usuario
     */
    @Test
    public void testComprobarAccesoCorrecto() {
        Usuario usuario = crearUsuario();
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        AccesoDTO accesoDTO = new AccesoDTO("juan@example.com", "Prueba1234!");

        UsuarioDTOSalida usuarioDTOSalida = usuarioService.comprobarAcceso(accesoDTO);

        // Validación de que no haya errores
        assertThat(usuarioDTOSalida.getErrores()).isEmpty();

        usuarioRepository.delete(usuario);
    }

    /**
     * Caso de prueba para comprobar un acceso incorrecto por parte de un usuario
     */
    @Test
    public void testComprobarAccesoIncorrecto() {
        Usuario usuario = crearUsuario();
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        AccesoDTO accesoDTO = new AccesoDTO("Mateo", "incorrecto");

        // Usa la instancia inyectada aquí también
        UsuarioDTOSalida usuarioDTOSalida = usuarioService.comprobarAcceso(accesoDTO);

        // Comprobación de error por acceso
        AssertionsForClassTypes.assertThat(usuarioDTOSalida.getErrores().get(0)).isEqualTo("Error de acceso");

        usuarioRepository.delete(usuario);
    }


    /**
     * Método empleado para probar crear un usuario
     */
    public Usuario crearUsuario(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Mateo");
        usuario.setEstado("DESEMPLEADO");
        usuario.setContrasena("Prueba1234!");
        usuario.setUsuario("Mateo");
        usuario.setApellidos("Martínez");
        usuario.setEmail("juan@example.com");
        return usuario;
    }
}
