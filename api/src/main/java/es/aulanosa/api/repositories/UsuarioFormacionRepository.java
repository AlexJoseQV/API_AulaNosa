package es.aulanosa.api.repositories;

import es.aulanosa.api.models.UsuarioFormacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 *  Interfaz para el respositorio de UsuarioFormacion
 *  Esta interfaz extiende JpaRepository, proporcionando métodos CRUD para la entidad UsuarioFormacion
 */
public interface UsuarioFormacionRepository extends JpaRepository<UsuarioFormacion, Integer> {

    List<UsuarioFormacion> findAllByFormacionId(int formacionId);
    /**
     * Este método permite inscribir un usuario en una formación
     * @param idUsuario identificador del usuario
     * @param id identificador de la formacion
     * @param estado estado de la inscripción
     */
    @Modifying
    @Transactional
    @Query("INSERT INTO UsuarioFormacion(usuarioId,formacionId,estado) VALUES(:idUsuario,:id,:estado) ")
    void insertar(@Param("idUsuario") int idUsuario,@Param("id")int id,String estado);

    /**
     * Este método permite eliminar un usuario de una formación
     * @param id identificador del usuario
     * @param formacionId identificador de la formación
     */
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query("DELETE FROM UsuarioFormacion WHERE usuarioId = :id AND formacionId = :formacionId")
    void deleteById(@Param("id")int id,@Param("formacionId") int formacionId);


    @Query("from UsuarioFormacion where ( usuarioId = :idUsuario AND formacionId = :idFormacion) ")
    UsuarioFormacion consultarFormacion(@Param("idUsuario") int idUsuario,@Param("idFormacion")int idFormacion);

}
