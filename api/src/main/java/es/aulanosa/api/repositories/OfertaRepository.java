package es.aulanosa.api.repositories;

import es.aulanosa.api.dtos.OfertaDTO;
import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Interfaz para el respositorio de Oferta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Oferta
 * @author MARTINCARBALLO
 */
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

    /**
     * Método empleado para obtener todas la información de todas las ofertas que se encuentran en el estado indicado ordenados por fechas más recientes
     * @param estado Estado en el que se encuentra la oferta
     * @return Se devuelve un listado con la información de las ofertas que se encuentran en el estado indicado ordenadas por las más recientes
     */
    List<Oferta> findByEstadoOrderByFechaDesc(String estado);
    /**
     * Este método permite crear una oferta
     * @param ofertaDTO objeto de la clase Oferta
     */
    @Modifying
    @Transactional
    @Query("INSERT INTO Oferta(titulo,descripcion,requisitos,vacantes,estado,imagen,fecha) VALUES(:ofertaDTO)")
    void insertar(@RequestBody OfertaDTO ofertaDTO);
}
