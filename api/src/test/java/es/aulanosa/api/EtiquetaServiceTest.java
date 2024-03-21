package es.aulanosa.api;
import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.repositories.EtiquetaRepository;
import es.aulanosa.api.services.EtiquetaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Esta clase contiene el test de EtiquetaService
 */
@SpringBootTest
public class EtiquetaServiceTest {
    @Autowired
    private EtiquetaService etiquetaService;
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     * Este test comprueba que no haya errores al listar las etiquetas
     */
    @Test
    public void testListarEtiquetas(){
        List<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas.add(new Etiqueta(1,"Etiqueta1"));
        etiquetas.add(new Etiqueta(2,"Etiqueta2"));
        etiquetaRepository.saveAll(etiquetas);
        ListaEtiquetaDTOSalida listaEtiquetaDTOSalida = etiquetaService.listarEtiquetas();
        assertThat(listaEtiquetaDTOSalida.getErrores().isEmpty());
        etiquetaRepository.deleteAll(etiquetas);
    }

    /**
     * Test que comprueba que no haya errores al listar las etiquetas por id de usuario
     */
    @Test
    public void testBuscarEtiquetaPorId() {

        Etiqueta etiqueta = new Etiqueta(1,"Etiqueta3");
        etiqueta = etiquetaRepository.save(etiqueta);
        ListaEtiquetaDTOSalida encontrado = etiquetaService.listarInteresesUsuario(etiqueta.getId());
        assertThat(encontrado.getErrores().isEmpty());
        etiquetaRepository.delete(etiqueta);
    }

}
