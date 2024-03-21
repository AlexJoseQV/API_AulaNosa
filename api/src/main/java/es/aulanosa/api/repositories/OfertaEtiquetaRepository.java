package es.aulanosa.api.repositories;
import es.aulanosa.api.models.FormacionEtiqueta;
import es.aulanosa.api.models.OfertaEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Interfaz para el respositorio de Usuario
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad OfertaEtiqueta
 * @author RubénC
 */
public interface OfertaEtiquetaRepository extends JpaRepository <OfertaEtiqueta, Integer> {

    public List<OfertaEtiqueta> findAllByOfertaId(int ofertaId) ;
}
