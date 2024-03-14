package es.aulanosa.api.repositories;
import es.aulanosa.api.models.OfertaEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interfaz para el respositorio de Usuario
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad OfertaEtiqueta
 * @author RubénC
 */
public interface OfertaEtiquetaRepository extends JpaRepository <OfertaEtiqueta, Integer> {

}
