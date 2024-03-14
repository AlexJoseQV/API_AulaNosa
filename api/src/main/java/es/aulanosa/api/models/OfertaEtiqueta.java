package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "ofertas_etiquetas")
@Entity
public class OfertaEtiqueta {

    @Id

    private int usuarioId; //identificador de usuario//

    private int ofertaId; //identificador de oferta//

    public OfertaEtiqueta(int usuarioId, int ofertaId) {
        this.usuarioId = usuarioId;
        this.ofertaId = ofertaId;
    }

    //Constructor vacío//
    public OfertaEtiqueta() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    @Override
    public String toString() {
        return "OfertaEtiqueta{" +
                "usuarioId=" + usuarioId +
                ", ofertaId=" + ofertaId +
                '}';
    }
}
