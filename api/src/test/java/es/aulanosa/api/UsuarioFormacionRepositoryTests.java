package es.aulanosa.api;

import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.models.UsuarioFormacion;
import es.aulanosa.api.repositories.FormacionRepository;
import es.aulanosa.api.repositories.UsuarioEtiquetaRepository;
import es.aulanosa.api.repositories.UsuarioFormacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * clase para los test de UsuarioFormacion
 */
@SpringBootTest
class UsuarioFormacionRepositoryTests {
	@Autowired
	private UsuarioFormacionRepository usuarioFormacionRepository;

	/**
	 * test guardar
	 */
	@Test
	public void testGuardarUsuarioFormacion() {

		UsuarioFormacion uf = crearUsuarioFormacion();



		UsuarioFormacion formacionGuardado = usuarioFormacionRepository.save(uf);
		assertThat(formacionGuardado).isNotNull();
		assertThat(formacionGuardado.getId()).isNotNull();
		usuarioFormacionRepository.delete(uf);
	}

	/**
	 * test busdar por id
	 */
	@Test
	public void testBuscarUsuarioFormacionPorId() {

		UsuarioFormacion uf = crearUsuarioFormacion();
		uf= usuarioFormacionRepository.save(uf);


		Optional<UsuarioFormacion> encontrada = usuarioFormacionRepository.findById(uf.getId());
		assertThat(encontrada).isNotEmpty();
		assertThat(encontrada.get().getId()).isEqualTo(1);
		usuarioFormacionRepository.delete(uf);
	}

	/**
	 * test actualizar
	 */
	@Test
	public void testActualizarUsuarioFormacion() {

		UsuarioFormacion uf = crearUsuarioFormacion();
		uf= usuarioFormacionRepository.save(uf);


		uf.setEstado("ACEPTADO");
		UsuarioFormacion formacionActualizada = usuarioFormacionRepository.save(uf);

		assertThat(formacionActualizada.getEstado()).isEqualTo("ACEPTADO");
		usuarioFormacionRepository.delete(uf);
	}

	/**
	 * test eliminacion
	 */
	@Test
	public void testEliminarUsuarioFormacion() {

		UsuarioFormacion uf = crearUsuarioFormacion();
		uf= usuarioFormacionRepository.save(uf);


		usuarioFormacionRepository.delete(uf);

		Optional<UsuarioFormacion> formacioneliminada = usuarioFormacionRepository.findById(uf.getId());
		assertThat(formacioneliminada).isEmpty();
	}

	/**
	 * crear UsuarioFormacion
	 * @return devuelve objeto creado
	 */

	public UsuarioFormacion crearUsuarioFormacion(){

		UsuarioFormacion uf = new UsuarioFormacion();
		uf.setFormacion_id(1);
		uf.setUsuario_id(1);
		uf.setEstado("INSCRITO");

		return uf;
	}

}
