package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    
}
