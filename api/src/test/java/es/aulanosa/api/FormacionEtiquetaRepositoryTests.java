package es.aulanosa.api;

import es.aulanosa.api.models.FormacionEtiqueta;
import es.aulanosa.api.repositories.FormacionEtiquetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * clase de test para la Formacionetiqueta
 */
@SpringBootTest
class FormacionEtiquetaRepositoryTests {
    @Autowired
    private FormacionEtiquetaRepository formacionEtiquetaRepository;

    /**
     * Test para guardar una Formacionetiqueta
     */
    @Test
    public void testGuardarFormacionEtiqueta(){
        FormacionEtiqueta fe = crearFormacionEtiqueta();

        FormacionEtiqueta etiquetaGuardada = formacionEtiquetaRepository.save(fe);
        assertThat(etiquetaGuardada).isNotNull();
        assertThat(etiquetaGuardada.getId()).isNotNull();
        formacionEtiquetaRepository.delete(fe);
    }

    /**
     * Test para buscar una Formacionetiqueta por el id
     */
    @Test
    public void testBuscarEtiquetaPorId() {

        FormacionEtiqueta fe = crearFormacionEtiqueta();
        fe = formacionEtiquetaRepository.save(fe);

        Optional<FormacionEtiqueta> encontrado = formacionEtiquetaRepository.findById(fe.getId());
        assertThat(encontrado).isNotEmpty();
        assertThat(encontrado.get().getFormacionId()).isEqualTo(1);
        formacionEtiquetaRepository.delete(fe);
    }

    /**
     * Test para actualizar una FormacionEtiqueta
     */
    @Test
    public void testActualizarEtiqueta() {

        FormacionEtiqueta fe = crearFormacionEtiqueta();
        fe = formacionEtiquetaRepository.save(fe);


        fe.setFormacionId(2);
        FormacionEtiqueta etiquetaActualizado = formacionEtiquetaRepository.save(fe);

        assertThat(etiquetaActualizado.getFormacionId()).isEqualTo(2);
        formacionEtiquetaRepository.delete(fe);
    }

    /**
     * Test para eliminar una FormacionEtiqueta
     */
    @Test
    public void testEliminarEtiqueta() {

        FormacionEtiqueta fe = crearFormacionEtiqueta();
        fe = formacionEtiquetaRepository.save(fe);


        formacionEtiquetaRepository.delete(fe);

        Optional<FormacionEtiqueta> etiquetaEliminada = formacionEtiquetaRepository.findById(fe.getId());
        assertThat(etiquetaEliminada).isEmpty();
    }

    /**
     * Método para crear una FormacionEtiqueta
     * @return objeto FormacionEtiqueta
     */
    public FormacionEtiqueta crearFormacionEtiqueta(){
        FormacionEtiqueta formacionEtiqueta = new FormacionEtiqueta();
        formacionEtiqueta.setEtiquetaId(13);
        formacionEtiqueta.setFormacionId(1);
        return formacionEtiqueta;
    }
}
