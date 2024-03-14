package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
}
