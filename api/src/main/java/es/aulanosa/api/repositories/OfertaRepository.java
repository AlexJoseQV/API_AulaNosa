package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para el respositorio de Oferta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Oferta
 * @author MARTINCARBALLO
 */
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

    
}
