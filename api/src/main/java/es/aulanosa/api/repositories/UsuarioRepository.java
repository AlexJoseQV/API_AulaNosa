package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz para el respositorio de Usuario
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Usuario
 * @author ALEXJOSE
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    /**
     * Se define un método para buscar un usuario por su email
     * @param email Email del usuario buscado
     * @return Se devuelve el modelo del usuario
     */
    Optional<Usuario> findByEmail(String email);

}
