package es.aulanosa.api.repositories;

import es.aulanosa.api.models.FormacionEtiqueta;
import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.models.UsuarioFormacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interfaz para el respositorio de FormacionEtiqueta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad FormacionEtiqueta
 */
public interface FormacionEtiquetaRepository extends JpaRepository< FormacionEtiqueta, Integer> {


   public List<FormacionEtiqueta> findAllByFormacionId(int formacionId) ;
}
