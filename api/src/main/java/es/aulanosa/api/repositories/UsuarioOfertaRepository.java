package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.models.UsuarioOferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioOfertaRepository extends JpaRepository<UsuarioOferta, Integer> {
}
