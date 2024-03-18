package es.aulanosa.api;

import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.models.UsuarioOferta;
import es.aulanosa.api.repositories.OfertaRepository;
import es.aulanosa.api.repositories.UsuarioOfertaRepository;
import es.aulanosa.api.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Clase empleada para la realización de pruebas con el repositorio UsuarioOferta
 * @author ALEXJOSE
 */
@SpringBootTest
public class UsuarioOfertaRepositoryTests {

    @Autowired
    private UsuarioOfertaRepository usuarioOfertaRepository; // Instancia de la clase repositorio del UsuarioOferta
    @Autowired
    private UsuarioRepository usuarioRepository; // Instancia de la clase repositorio del Usuario
    @Autowired
    private OfertaRepository ofertaRepository; // Instancia de la clase repositorio de Oferta

    /**
     * Caso de prueba para probar que se puede guardar una inscripción de un usuario con respecto a una oferta
     */
    @Test
    public void testGuardarUsuarioOferta(){
        Usuario usuario = crearUsuario();
        Oferta oferta = crearOferta();

        Usuario usuarioInsertado = usuarioRepository.save(usuario);
        Oferta ofertaInsertada = ofertaRepository.save(oferta);

        UsuarioOferta uo = crearUsuarioOferta(usuarioInsertado.getId(), ofertaInsertada.getId());

        UsuarioOferta inscripcionGuardada = usuarioOfertaRepository.save(uo);

        // Se comprueba que se encuentre la inscripción
        assertThat(inscripcionGuardada).isNotNull();
        assertThat(inscripcionGuardada.getId()).isNotNull();

        usuarioOfertaRepository.delete(inscripcionGuardada);
        usuarioRepository.delete(usuarioInsertado);
        ofertaRepository.delete(ofertaInsertada);
    }

    /**
     * Caso de prueba que permite probar si se puede encontrar una inscripción a una oferta por su identificador
     */
    @Test
    public void testBuscarUsuarioOfertaPorId(){
        Usuario usuario = crearUsuario();
        Oferta oferta = crearOferta();

        Usuario usuarioInsertado = usuarioRepository.save(usuario);
        Oferta ofertaInsertada = ofertaRepository.save(oferta);

        UsuarioOferta uo = crearUsuarioOferta(usuarioInsertado.getId(), ofertaInsertada.getId());

        UsuarioOferta inscripcionGuardada = usuarioOfertaRepository.save(uo);

        Optional<UsuarioOferta> encontrado = usuarioOfertaRepository.findById(inscripcionGuardada.getId());
        assertThat(encontrado).isNotEmpty();
        assertThat(encontrado.get().getEstado()).isEqualTo("INSCRITO");

        usuarioOfertaRepository.delete(inscripcionGuardada);
        usuarioRepository.delete(usuarioInsertado);
        ofertaRepository.delete(ofertaInsertada);
    }

    /**
     * Caso de prueba que permite probar si se puede actualizar la inscripción a una oferta
     */
    @Test
    public void testActualizarUsuarioOferta(){
        Usuario usuario = crearUsuario();
        Oferta oferta = crearOferta();

        Usuario usuarioInsertado = usuarioRepository.save(usuario);
        Oferta ofertaInsertada = ofertaRepository.save(oferta);

        UsuarioOferta uo = crearUsuarioOferta(usuarioInsertado.getId(), ofertaInsertada.getId());

        uo.setEstado("RECHAZADO");
        UsuarioOferta inscripcionActualizada = usuarioOfertaRepository.save(uo);

        assertThat(inscripcionActualizada.getEstado()).isEqualTo("RECHAZADO");

        usuarioOfertaRepository.delete(inscripcionActualizada);
        usuarioRepository.delete(usuarioInsertado);
        ofertaRepository.delete(ofertaInsertada);
    }

    /**
     * Caso de prueba que permite probar si se puede eliminar una inscripción de una oferta
     */
    @Test
    public void eliminarUsuarioOferta(){
        Usuario usuario = crearUsuario();
        Oferta oferta = crearOferta();

        Usuario usuarioInsertado = usuarioRepository.save(usuario);
        Oferta ofertaInsertada = ofertaRepository.save(oferta);

        UsuarioOferta uo = crearUsuarioOferta(usuarioInsertado.getId(), ofertaInsertada.getId());

        UsuarioOferta inscripcion = usuarioOfertaRepository.save(uo);

        usuarioOfertaRepository.delete(inscripcion);
        usuarioRepository.delete(usuarioInsertado);
        ofertaRepository.delete(ofertaInsertada);

        Optional<UsuarioOferta> inscripcionEliminada = usuarioOfertaRepository.findById(uo.getId());
        assertThat(inscripcionEliminada).isEmpty();
    }

    /**
     * Método que permite crear un objeto que representa una inscripción a una oferta
     * @param idUsuario Identificador de un usuario
     * @param idOferta Identificador de una oferta
     * @return Se devuelve el objeto que representa la inscripción de un usuario para una oferta
     */
    public UsuarioOferta crearUsuarioOferta(int idUsuario, int idOferta) {
        UsuarioOferta uo = new UsuarioOferta();
        uo.setUsuarioId(idUsuario);
        uo.setOfertaId(idOferta);
        uo.setEstado("INSCRITO");

        return uo;
    }

    /**
     * Método que permite crear un objeto de usuario
     * @return Se devuelve el objeto de usuario creado
     */
    public Usuario crearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juán Pérez");
        usuario.setEstado("DESEMPLEADO");
        usuario.setContrasena("Prueba1234!");
        usuario.setUsuario("Juán");
        usuario.setApellidos("Martínez");
        usuario.setEmail("juanperez@example.com");
        return usuario;
    }

    /**
     * Método que permite crear un objeto oferta
     * @return Se devuelve el objeto oferta creado
     */
    public Oferta crearOferta() {
        Oferta oferta = new Oferta();
        oferta.setTitulo("Titulo");
        oferta.setEstado("ABIERTA");
        oferta.setDescripcion("Super descripcion");
        oferta.setVacantes(10);
        oferta.setRequisitos("");
        return oferta;
    }
}
