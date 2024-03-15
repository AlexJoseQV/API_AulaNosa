package es.aulanosa.api;
import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.repositories.EtiquetaRepository;
import es.aulanosa.api.services.EtiquetaService;
import es.aulanosa.api.services.impl.EtiquetaServiceImpl;
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

    private EtiquetaService etiquetaService;
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     * Este test comprueba que no haya errores al listar las etiquetas
     */
    @Test
    public void testListarEtiquetas(){
        etiquetaService = new EtiquetaServiceImpl();
        List<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas.add(new Etiqueta(1,"Etiqueta1"));
        etiquetas.add(new Etiqueta(2,"Etiqueta2"));
        etiquetaRepository.saveAll(etiquetas);
        ListaEtiquetaDTOSalida listaEtiquetaDTOSalida = etiquetaService.listarEtiquetas();
        assertThat(listaEtiquetaDTOSalida.getErrores().isEmpty());
        etiquetaRepository.deleteAll(etiquetas);
    }

}
