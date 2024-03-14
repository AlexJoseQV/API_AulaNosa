package es.aulanosa.api;

import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.repositories.OfertaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class OfertaRepositoryTests {
	@Autowired
	private OfertaRepository ofertaRepository;

	@Test
	public void testGuardarOferta() {
		Oferta oferta = crearOferta();

		Oferta ofertaGuardado = ofertaRepository.save(oferta);
		assertThat(ofertaGuardado).isNotNull();
		assertThat(ofertaGuardado.getId()).isNotNull();
		ofertaRepository.delete(oferta);
	}

	@Test
	public void testBuscarOfertaPorId() {

		Oferta oferta = crearOferta();
		oferta = ofertaRepository.save(oferta);

		Optional<Oferta> encontrado = ofertaRepository.findById(oferta.getId());
		assertThat(encontrado).isNotEmpty();
		assertThat(encontrado.get().getDescripcion()).isEqualTo("Super descripcion");
		ofertaRepository.delete(oferta);
	}

	@Test
	public void testActualizarOferta() {

		Oferta oferta = crearOferta();
		oferta = ofertaRepository.save(oferta);


		oferta.setTitulo("Mateo2 Actualizado");
		Oferta ofertaActualizado = ofertaRepository.save(oferta);

		assertThat(ofertaActualizado.getTitulo()).isEqualTo("Mateo2 Actualizado");
		ofertaRepository.delete(oferta);
	}

	@Test
	public void testEliminarOferta() {

		Oferta oferta = crearOferta();
		oferta = ofertaRepository.save(oferta);


		ofertaRepository.delete(oferta);

		Optional<Oferta> ofertaEliminado = ofertaRepository.findById(oferta.getId());
		assertThat(ofertaEliminado).isEmpty();
	}

	public Oferta crearOferta(){

		Oferta oferta = new Oferta();
		oferta.setTitulo("Titulo");
		oferta.setEstado("ABIERTA");
		oferta.setId(1);
		oferta.setDescripcion("Super descripcion");
		oferta.setVacantes(10);
		oferta.setRequisitos("");
		return oferta;
	}
}
