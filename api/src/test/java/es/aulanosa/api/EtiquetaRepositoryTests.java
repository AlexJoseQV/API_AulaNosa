package es.aulanosa.api;

import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.repositories.EtiquetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class EtiquetaRepositoryTests {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     * Test para guardar una etiqueta
     */
    @Test
    public void testGuardarEtiqueta(){
        Etiqueta etiqueta = crearEtiqueta();
        Etiqueta etiquetaGuardada = etiquetaRepository.save(etiqueta);
        assertThat(etiquetaGuardada).isNotNull();
        assertThat(etiquetaGuardada.getId()).isNotNull();
        etiquetaRepository.delete(etiqueta);
    }

    /**
     * Test para buscar una etiqueta por el id
     */
    @Test
    public void testBuscarEtiquetaPorId() {

        Etiqueta etiqueta = crearEtiqueta();
        etiqueta = etiquetaRepository.save(etiqueta);

        Optional<Etiqueta> encontrado = etiquetaRepository.findById(etiqueta.getId());
        assertThat(encontrado).isNotEmpty();
        assertThat(encontrado.get().getNombre()).isEqualTo("etiqueta1");
        etiquetaRepository.delete(etiqueta);
    }

    /**
     * Test para actualizar una etiqueta
     */
    @Test
    public void testActualizarEtiqueta() {

        Etiqueta etiqueta = crearEtiqueta();
        etiqueta = etiquetaRepository.save(etiqueta);


        etiqueta.setNombre("etiqueta2 Actualizado");
        Etiqueta etiquetaActualizado = etiquetaRepository.save(etiqueta);

        assertThat(etiquetaActualizado.getNombre()).isEqualTo("etiqueta2 Actualizado");
        etiquetaRepository.delete(etiqueta);
    }

    /**
     * Test para eliminar una etiqueta
     */
    @Test
    public void testEliminarEtiqueta() {

        Etiqueta etiqueta = crearEtiqueta();
        etiqueta = etiquetaRepository.save(etiqueta);


        etiquetaRepository.delete(etiqueta);

        Optional<Etiqueta> etiquetaEliminado = etiquetaRepository.findById(etiqueta.getId());
        assertThat(etiquetaEliminado).isEmpty();
    }

    /**
     * Método para crear una etiqueta
     * @return objeto etiqueta
     */
    public Etiqueta crearEtiqueta(){
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setNombre("etiqueta1");
        return etiqueta;
    }
}
