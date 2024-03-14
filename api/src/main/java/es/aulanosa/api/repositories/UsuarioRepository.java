package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para el respositorio de Usuario
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Usuario
 * @author RubénC
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
