package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para el respositorio de Etiqueta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Etiqueta
 * @author MATHIAS
 */
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
}
