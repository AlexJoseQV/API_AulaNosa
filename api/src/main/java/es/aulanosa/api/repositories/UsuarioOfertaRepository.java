package es.aulanosa.api.repositories;

import es.aulanosa.api.models.UsuarioOferta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz para el respositorio de UsuarioOferta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad UsuarioOferta
 * @author MARTINCARBALLO
 */
public interface UsuarioOfertaRepository extends JpaRepository<UsuarioOferta, Integer> {
    /**
     * Se define un método para obtener todas las ofertas por un identificador
     * @param ofertaId Identificador de la oferta
     * @return Se devuelve la información de las ofertas en un listado
     */
    List<UsuarioOferta> findAllByOfertaId(int ofertaId);
}
