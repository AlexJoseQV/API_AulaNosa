package es.aulanosa.api.repositories;

import es.aulanosa.api.models.FormacionEtiqueta;
import es.aulanosa.api.models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormacionEtiquetaRepository extends JpaRepository< FormacionEtiqueta, Integer> {
}
