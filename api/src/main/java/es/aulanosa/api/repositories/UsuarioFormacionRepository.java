package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.models.UsuarioEtiqueta;
import es.aulanosa.api.models.UsuarioFormacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 *  Interfaz para el respositorio de UsuarioFormacion
 *  Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad UsuarioFormacion
 */
public interface UsuarioFormacionRepository extends JpaRepository<UsuarioFormacion, Integer> {

    Optional<UsuarioFormacion> findByFormacionId(int formacionId);


}
