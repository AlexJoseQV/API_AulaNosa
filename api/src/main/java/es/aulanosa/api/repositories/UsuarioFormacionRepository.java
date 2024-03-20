package es.aulanosa.api.repositories;

import es.aulanosa.api.models.Etiqueta;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.models.UsuarioEtiqueta;
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
    @Query("INSERT INTO UsuarioFormacion(usuario_id,formacionId,estado) VALUES(:idUsuario,:id,:estado) ")
    void insertar(@Param("idUsuario") int idUsuario,@Param("id")int id,String estado);


    @Query("Select * from inscripciones_formaciones where ( usuario_id = :idUsuario AND formacion_id = :idFormacion) ")
    UsuarioFormacion consultarFormacion(@Param("idUsuario") int idUsuario,@Param("idFormacion")int idFormacion);



}
