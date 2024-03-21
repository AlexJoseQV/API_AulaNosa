package es.aulanosa.api.repositories;

import es.aulanosa.api.models.UsuarioEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para la Etiqueta de Usuario
 * @author Ruben
 */
public interface UsuarioEtiquetaRepository extends JpaRepository<UsuarioEtiqueta, Integer> {


     /**
      * Se define un método para obtener todas las relaciones de un usuario con sus etiquetas
      * @param usuarioId Identificador del usuario
      * @return Se devuelve un listado con todas las relaciones de un usuario con sus etiquetas
      */
     List<UsuarioEtiqueta> findAllByUsuarioId(int usuarioId);

     /**
      * Se devuelve una instancia de la relación de un usuario con respecto a una etiqueta
      * @param usuarioId Identificador del usuario
      * @param etiquetaId Identificador de la etiqueta
      * @return Se devuelve la instancia opcional de la relación del usuario con la etiqueta indicados
      */
     Optional<UsuarioEtiqueta> findByUsuarioIdAndEtiquetaId(int usuarioId, int etiquetaId);
}
