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
    @Column (name = "usuario_id")
    private int usuarioID;

    /**
     * Identificador de la oferta.
     */
    @Column (name = "oferta_id")
    private int ofertaID;

    /**
     * Estado de la relación usuario-oferta.
     */
    private String estado;

    public UsuarioOferta() {
    }

    public UsuarioOferta(int id, int usuarioID, int ofertaID, String estado) {
        this.id = id;
        this.usuarioID = usuarioID;
        this.ofertaID = ofertaID;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getOfertaID() {
        return ofertaID;
    }

    public void setOfertaID(int ofertaID) {
        this.ofertaID = ofertaID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioOferta{" +
                "id=" + id +
                ", usuarioID=" + usuarioID +
                ", ofertaID=" + ofertaID +
                ", estado='" + estado + '\'' +
                '}';
    }
}
