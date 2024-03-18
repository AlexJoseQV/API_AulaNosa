package es.aulanosa.api.models;

import jakarta.persistence.*;

/**
 * Esta clase representa la relación entre un usuario y una oferta.
 */
@Table(name = "inscripciones_ofertas")
@Entity
public class UsuarioOferta {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    /**
     * Identificador del usuario.
     */
    @Column(name = "usuario_id")
    private int usuarioId;

    /**
     * Identificador de la oferta.
     */
    @Column(name = "oferta_id")
    private int ofertaId;

    /**
     * Estado de la relación usuario-oferta.
     */
    private String estado;

    /**
     * Constructor por defecto de la clase UsuarioOferta.
     */
    public UsuarioOferta() {
    }

    public UsuarioOferta(int id, int usuarioId, int ofertaId, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.ofertaId = ofertaId;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioOferta{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", ofertaId=" + ofertaId +
                ", estado='" + estado + '\'' +
                '}';
    }

}
