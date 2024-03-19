package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz para el respositorio de Usuario
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Usuario
 * @author RubénC
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    /**
     * Se define un método para buscar un usuario por su email
     * @param email Email del usuario a buscar
     * @return Se devuelve la información del usuario buscado
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Se define un método para buscar un usuario por su nombre identificador
     * @param usuario Nombre identificador del usuario
     * @return Se devuelve la información del usuario buscado
     */
    Optional<Usuario> findByUsuario(String usuario);
}
