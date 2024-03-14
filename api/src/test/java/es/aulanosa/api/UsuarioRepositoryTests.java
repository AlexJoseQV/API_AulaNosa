package es.aulanosa.api;

import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Clase empleada para la realización de pruebas con el repositorio de Usuario
 * @author ALEXJOSE
 */
@SpringBootTest
class UsuarioRepositoryTests {
	@Autowired
	private UsuarioRepository usuarioRepository; // Instancia de la clase repositorio del usuario

	/**
	 * Método empleado para probar guardar un usuario
	 */
	@Test
	public void testGuardarUsuario() {
		Usuario usuario = crearUsuario();

		Usuario usuarioGuardado = usuarioRepository.save(usuario);
		assertThat(usuarioGuardado).isNotNull();
		assertThat(usuarioGuardado.getId()).isNotNull();
		usuarioRepository.delete(usuario);
	}

	/**
	 * Método empleado para probar a buscar un usuario por su identificador
	 */
	@Test
	public void testBuscarUsuarioPorId() {

		Usuario usuario = crearUsuario();
		usuario = usuarioRepository.save(usuario);

		Optional<Usuario> encontrado = usuarioRepository.findById(usuario.getId());
		assertThat(encontrado).isNotEmpty();
		assertThat(encontrado.get().getEmail()).isEqualTo("juan@example.com");
		usuarioRepository.delete(usuario);
	}

	/**
	 * Método empleado para probar actualizar un usuario
	 */
	@Test
	public void testActualizarUsuario() {

		Usuario usuario = crearUsuario();
		usuario = usuarioRepository.save(usuario);


		usuario.setNombre("Mateo2 Actualizado");
		Usuario usuarioActualizado = usuarioRepository.save(usuario);

		assertThat(usuarioActualizado.getNombre()).isEqualTo("Mateo2 Actualizado");
		usuarioRepository.delete(usuario);
	}

	/**
	 * Método empleado para probar eliminar un usuario
	 */
	@Test
	public void testEliminarUsuario() {

		Usuario usuario = crearUsuario();
		usuario = usuarioRepository.save(usuario);


		usuarioRepository.delete(usuario);

		Optional<Usuario> usuarioEliminado = usuarioRepository.findById(usuario.getId());
		assertThat(usuarioEliminado).isEmpty();
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
