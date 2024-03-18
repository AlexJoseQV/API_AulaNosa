package es.aulanosa.api.repositories;

import es.aulanosa.api.models.FormacionEtiqueta;
import es.aulanosa.api.models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para el respositorio de FormacionEtiqueta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad FormacionEtiqueta
 */
public interface FormacionEtiquetaRepository extends JpaRepository< FormacionEtiqueta, Integer> {
}
