package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.Normalizer;
import java.util.Optional;

/**
 * interface formacion
 */
public interface FormacionRepository extends JpaRepository < Formacion, Integer> {

    Optional<Formacion> findByTitulo(String titulo);
}
