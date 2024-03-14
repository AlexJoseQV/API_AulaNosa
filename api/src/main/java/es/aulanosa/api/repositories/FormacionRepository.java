package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interface formacion
 */
public interface FormacionRepository extends JpaRepository < Formacion, Integer> {
}
