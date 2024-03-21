package es.aulanosa.api;

import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.repositories.FormacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * clase para los test de formacion
 */
@SpringBootTest
class FormacionRepositoryTests {
	@Autowired
	private FormacionRepository formacionRepository;

	/**
	 * test guardar
	 */
	@Test
	public void testGuardarFormacion() {

		Formacion formacion = crearFormacion();


		Formacion formacionGuardado = formacionRepository.save(formacion);
		assertThat(formacionGuardado).isNotNull();
		assertThat(formacionGuardado.getId()).isNotNull();
		formacionRepository.delete(formacion);
	}

	/**
	 * test busdar por id
	 */
	@Test
	public void testBuscarFormacionPorId() {

		Formacion formacion = crearFormacion();
		formacion= formacionRepository.save(formacion);

		Optional<Formacion> encontrada = formacionRepository.findById(formacion.getId());
		assertThat(encontrada).isNotEmpty();
		assertThat(encontrada.get().getDescripcion()).isEqualTo("este es una prueba de la descripcion");
		formacionRepository.delete(formacion);
	}

	/**
	 * test actualizar
	 */
	@Test
	public void testActualizarFormacion() {

		Formacion formacion = crearFormacion();
		formacion= formacionRepository.save(formacion);


		formacion.setTitulo("titulo Actualizado");
		Formacion formacionActualizada = formacionRepository.save(formacion);

		assertThat(formacionActualizada.getTitulo()).isEqualTo("titulo Actualizado");
		formacionRepository.delete(formacion);
	}

	/**
	 * test eliminacion
	 */
	@Test
	public void testEliminarFormacion() {

		Formacion formacion = crearFormacion();
		formacion= formacionRepository.save(formacion);


		formacionRepository.delete(formacion);

		Optional<Formacion> formacioneliminada = formacionRepository.findById(formacion.getId());
		assertThat(formacioneliminada).isEmpty();
	}

	/**
	 * crear formacion
	 * @return devuelve objeto creado
	 */

	public Formacion crearFormacion(){

		Formacion formacion = new Formacion();
		formacion.setTitulo("este es un titulo de prueba ");
		formacion.setDescripcion("este es una prueba de la descripcion");
		formacion.setRequisitos("requisito1||requisito2||requisito3");
		formacion.setInicio(new Date(2024,3,14));
		formacion.setFin(new Date(2024,4,1));
		formacion.setCoste(2000);
		formacion.setEstado("ABIERTA");
		formacion.setImagen(new ArrayList<Byte>(0101010101));
		return formacion;
	}

}
