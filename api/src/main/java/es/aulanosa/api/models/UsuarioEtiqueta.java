package es.aulanosa.api.models;

import jakarta.persistence.*;
@Table(name = "usuarios_etiquetas")
@Entity
public class UsuarioEtiqueta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int usuarioId; //identificador de usuario//

    private int etiquetaId; //identificador de etiqueta//


    /**
     * Constructor completo
     * @param id identificador
     * @param usuarioId identificador del usuario
     * @param etiquetaId identificador de la etiqueta
     */
    public UsuarioEtiqueta(int id, int usuarioId, int etiquetaId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.etiquetaId = etiquetaId;
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



    @Column(name = "etiqueta_id")
    public int getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(int etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    @Override
    public String toString() {
        return "UsuarioEtiqueta{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", etiquetaId=" + etiquetaId +
                '}';
    }
}
