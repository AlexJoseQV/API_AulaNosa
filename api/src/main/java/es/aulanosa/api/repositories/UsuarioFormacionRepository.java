package es.aulanosa.api.repositories;

import es.aulanosa.api.models.UsuarioEtiqueta;
import es.aulanosa.api.models.UsuarioFormacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  Interfaz para el respositorio de UsuarioFormacion
 *  Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad UsuarioFormacion
 */
public interface UsuarioFormacionRepository extends JpaRepository<UsuarioFormacion, Integer> {
}
