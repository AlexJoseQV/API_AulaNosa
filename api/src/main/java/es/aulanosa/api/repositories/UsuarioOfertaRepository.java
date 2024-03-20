package es.aulanosa.api.repositories;

import es.aulanosa.api.models.UsuarioOferta;
import org.springframework.data.jpa.repository.JpaRepository;
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

    @Query("from inscripciones_ofertas where (usuarioID = :idUsuario AND ofertaID = :idOferta)")
    UsuarioOferta consultarOferta(@Param("idUsuario") int idUsuario, @Param("idOferta")int idOferta);
}
