package es.aulanosa.api.repositories;

import es.aulanosa.api.models.FormacionEtiqueta;
import es.aulanosa.api.models.UsuarioEtiqueta;
import es.aulanosa.api.models.UsuarioFormacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interfaz para la Etiqueta de Usuario
 * @author Ruben
 */
public interface UsuarioEtiquetaRepository extends JpaRepository<UsuarioEtiqueta, Integer> {


     List<UsuarioEtiqueta> findAllByUsuarioId(int usuarioId) ;
}
