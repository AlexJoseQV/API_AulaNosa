package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Table(name = "usuarios_etiquetas")
@Entity
public class UsuarioEtiqueta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int usuarioId; //identificador de usuario//

    private int etiqueta_id; //identificador de etiqueta//


    /**
     * Constructor completo
     * @param id identificador
     * @param usuarioId identificador del usuario
     * @param etiqueta_id identificador de la etiqueta
     */
    public UsuarioEtiqueta(int id, int usuarioId, int etiqueta_id) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.etiqueta_id = etiqueta_id;
    }

    /**
     * Constructor vacío
     */
    public UsuarioEtiqueta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@Column(name = "usuario_id")
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    @Override
    public String toString() {
        return "UsuarioEtiqueta{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", etiqueta_id=" + etiqueta_id +
                '}';
    }
}
