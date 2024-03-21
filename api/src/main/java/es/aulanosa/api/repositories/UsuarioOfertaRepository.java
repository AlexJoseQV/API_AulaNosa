package es.aulanosa.api.repositories;

import es.aulanosa.api.models.UsuarioOferta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interfaz para el respositorio de UsuarioOferta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad UsuarioOferta
 * @author MARTINCARBALLO
 */
public interface UsuarioOfertaRepository extends JpaRepository<UsuarioOferta, Integer> {
    List<UsuarioOferta> findAllByOfertaId(int ofertaId);
    /**
     * Este método permite inscribir un usuario en una formación
     * @param idUsuario identificador del usuario
     * @param idOferta identificador de la oferta
     * @param estado estado de la oferta
     */
    @Modifying
    @Transactional
    @Query("INSERT INTO UsuarioOferta(usuarioId,ofertaId,estado) VALUES(:idUsuario,:idOferta,:estado) ")
    void insertar(@Param("idUsuario") int idUsuario, @Param("idOferta")int idOferta, @Param("estado") String estado);

    @Query("from UsuarioOferta where ( usuarioId = :idUsuario AND ofertaId = :idOferta) ")
    UsuarioOferta consultarOferta(@Param("idUsuario") int idUsuario, @Param("idOferta") int idOferta);
}
