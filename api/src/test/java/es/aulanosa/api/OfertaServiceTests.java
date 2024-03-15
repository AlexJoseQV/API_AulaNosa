package es.aulanosa.api;

import es.aulanosa.api.dtos.ListaOfertaDTOSalida;
import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.repositories.OfertaRepository;
import es.aulanosa.api.services.OfertaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clase empleada para la realización de pruebas con el service de Oferta
 * @author ALEXJOSE
 */
@SpringBootTest
public class OfertaServiceTests {
    @Autowired
    private OfertaRepository ofertaRepository; // Instancia de la clase repositorio de oferta
    @Autowired
    private OfertaService ofertaService; // Instancia del servicio de oferta

    /**
     * Caso de prueba para comprobar la devolución de todas las ofertas
     */
    @Test
    public void testComprobarObtener() {
        Oferta oferta = crearOferta();
        Oferta ofertaGuardada = ofertaRepository.save(oferta);

        ListaOfertaDTOSalida listaOfertaDTOSalida = ofertaService.listarOfertas();
        assertThat(listaOfertaDTOSalida.getErrores()).isEmpty(); // Se comprueba que no haya errores

        ofertaRepository.delete(oferta);
    }

    /**
     * Método empleado para probar crear una oferta
     */
    public Oferta crearOferta(){

        Oferta oferta = new Oferta();
        oferta.setVacantes(2);
        oferta.setTitulo("Ejemplo");
        oferta.setRequisitos("Requisito1$$Requisito2$$Requisito3$$");
        oferta.setEstado("ABIERTA");
        oferta.setDescripcion("Descripción de ejemplo");
        oferta.setFecha(new Timestamp(System.currentTimeMillis()));
        oferta.setImagen(new ArrayList<>());
        return oferta;
    }
}
