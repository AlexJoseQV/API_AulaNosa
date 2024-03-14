package es.aulanosa.api;

import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.repositories.FormacionRepository;
import es.aulanosa.api.repositories.UsuarioRepository;
import jakarta.persistence.criteria.From;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class FormacionRepositoryTests {
	@Autowired
	private FormacionRepository formacionRepository;

	@Test
	public void testGuardarFormacion() {

		Formacion formacion = crearFormacion();


		Formacion formacionGuardado = formacionRepository.save(formacion);
		assertThat(formacionGuardado).isNotNull();
		assertThat(formacionGuardado.getId()).isNotNull();
		formacionRepository.delete(formacion);
	}

	@Test
	public void testBuscarFormacionPorId() {

		Formacion formacion = crearFormacion();
		formacion= formacionRepository.save(formacion);

		Optional<Formacion> encontrada = formacionRepository.findById(formacion.getId());
		assertThat(encontrada).isNotEmpty();
		assertThat(encontrada.get().getDescripcion()).isEqualTo("este es una prueba de la descripcion");
		formacionRepository.delete(formacion);
	}

	@Test
	public void testActualizarFormacion() {

		Formacion formacion = crearFormacion();
		formacion= formacionRepository.save(formacion);


		formacion.setTitulo("titulo Actualizado");
		Formacion formacionActualizada = formacionRepository.save(formacion);

		assertThat(formacionActualizada.getTitulo()).isEqualTo("titulo Actualizado");
		formacionRepository.delete(formacion);
	}

	@Test
	public void testEliminarFormacion() {

		Formacion formacion = crearFormacion();
		formacion= formacionRepository.save(formacion);


		formacionRepository.delete(formacion);

		Optional<Formacion> formacioneliminada = formacionRepository.findById(formacion.getId());
		assertThat(formacioneliminada).isEmpty();
	}

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
