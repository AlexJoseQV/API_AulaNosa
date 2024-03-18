package es.aulanosa.api.repositories;

import es.aulanosa.api.dtos.EtiquetaDTO;
import es.aulanosa.api.models.Etiqueta;
<<<<<<< HEAD
import org.hibernate.annotations.NamedQuery;
=======
import jakarta.transaction.Transactional;
>>>>>>> EndpointUsuariosInteresesIns
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Interfaz para el respositorio de Etiqueta
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad Etiqueta
 * @author MATHIAS
 */
@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
    /**
     * Este método permite listar las etiquetas por el identificador del usuario usando la consulta que se encuentra en la anotación Query
     * @param id identificador del usuario
     * @return lista de etiquetas
     */
    @Query("SELECT e\n" +
            "FROM UsuarioEtiqueta ue INNER JOIN Usuario u\n" +
            "on ue.usuario_id = u.id INNER JOIN Etiqueta e\n" +
            "on ue.etiqueta_id = e.id\n" +
            "WHERE u.id = :id")
    List<Etiqueta>findById(@Param("id")int id);

    /**
<<<<<<< HEAD
     * Este método permite eliminar los intereses de un usuario en concreto
     * @param id identificador del usuario
     */
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query("DELETE FROM UsuarioEtiqueta WHERE usuario_id = :id")
    void deleteById(@Param("id")int id);
=======
     * Este método permite registrar una etiqueta a un usuario para saber sus intereses
     * @param id identificador del usuario
     * @param idEtiqueta identificador de la etiqueta
     */
    @Modifying
    @Transactional
    @Query("INSERT INTO UsuarioEtiqueta(usuario_id,etiqueta_id) VALUES(:id,:idEtiqueta) ")
    void insertar(@Param("id")int id, @Param("idEtiqueta") int idEtiqueta);

>>>>>>> EndpointUsuariosInteresesIns
}
