package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para el respositorio de Etiqueta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Etiqueta
 * @author MATHIAS
 */
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
    List<Etiqueta> findById(int id);
}
