package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.models.UsuarioOferta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para el respositorio de UsuarioOferta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad UsuarioOferta
 * @author MARTINCARBALLO
 */
public interface UsuarioOfertaRepository extends JpaRepository<UsuarioOferta, Integer> {
}
