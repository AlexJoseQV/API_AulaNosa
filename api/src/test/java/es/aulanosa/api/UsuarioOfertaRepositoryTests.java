package es.aulanosa.api;

import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.models.UsuarioOferta;
import es.aulanosa.api.repositories.OfertaRepository;
import es.aulanosa.api.repositories.UsuarioOfertaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Esta clase contiene pruebas unitarias para la clase UsuarioOferta.
 */
@SpringBootTest
class UsuarioOfertaRepositoryTests {

	@Autowired
	private UsuarioOfertaRepository uoRepository;

	/**
	 * Prueba guardar una relación usuario-oferta.
	 */
	@Test
	public void testGuardarOferta() {
		UsuarioOferta uo = crearUsuarioOferta();

		UsuarioOferta uoGuardado = uoRepository.save(uo);
		assertThat(uoGuardado).isNotNull();
		assertThat(uoGuardado.getId()).isNotNull();
		uoRepository.delete(uo);
	}

	/**
	 * Prueba buscar una relación usuario-oferta por su identificador.
	 */
	@Test
	public void testBuscarOfertaPorId() {
		UsuarioOferta uo = crearUsuarioOferta();
		uo = uoRepository.save(uo);

		Optional<UsuarioOferta> encontrado = uoRepository.findById(uo.getId());
		assertThat(encontrado).isNotEmpty();
		assertThat(encontrado.get().getEstado()).isEqualTo("INSCRITO");
		uoRepository.delete(uo);
	}

	/**
	 * Prueba actualizar una relación usuario-oferta.
	 */
	@Test
	public void testActualizarOferta() {
		UsuarioOferta uo = crearUsuarioOferta();
		uo = uoRepository.save(uo);

		uo.setEstado("RECHAZADO");
		UsuarioOferta ofertaActualizado = uoRepository.save(uo);

		assertThat(ofertaActualizado.getEstado()).isEqualTo("RECHAZADO");
		uoRepository.delete(uo);
	}

	/**
	 * Prueba eliminar una relación usuario-oferta.
	 */
	@Test
	public void testEliminarOferta() {
		UsuarioOferta uo = crearUsuarioOferta();
		uo = uoRepository.save(uo);

		uoRepository.delete(uo);

		Optional<UsuarioOferta> ofertaEliminado = uoRepository.findById(uo.getId());
		assertThat(ofertaEliminado).isEmpty();
	}

	/**
	 * Crea una relación usuario-oferta de prueba.
	 * @return La relación usuario-oferta de prueba creada.
	 */
	public UsuarioOferta crearUsuarioOferta() {
		UsuarioOferta uo = new UsuarioOferta();
		uo.setId(1);
		uo.setOferta_id(1);
		uo.setUsuario_id(1);
		uo.setEstado("INSCRITO");

		return uo;
	}
}
