package es.aulanosa.api.repositories;

import es.aulanosa.api.models.FormacionEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz para el respositorio de FormacionEtiqueta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad FormacionEtiqueta
 */
public interface FormacionEtiquetaRepository extends JpaRepository< FormacionEtiqueta, Integer> {


   public List<FormacionEtiqueta> findAllByFormacionId(int formacionId) ;
}
