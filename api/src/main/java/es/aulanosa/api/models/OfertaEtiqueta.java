package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "ofertas_etiquetas")
@Entity
public class OfertaEtiqueta {

    @Id

    private int usuario_id; //identificador de usuario//

    private int oferta_id; //identificador de oferta//

    /**
     * constructor completo
     * @Param usuario_id es el identificador de usuario
     * @Param oferta_id es el identificador de las ofertas
     */
    public OfertaEtiqueta(int usuario_id, int oferta_id) {
        this.usuario_id = usuario_id;
        this.oferta_id = oferta_id;
    }

/*
constructor vacío
 */

    public OfertaEtiqueta() {
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(int oferta_id) {
        this.oferta_id = oferta_id;
    }

    /**
     * Método toString
     * @return cadena con los identificadores de usuario y ofertas
     */
    @Override
    public String toString() {
        return "OfertaEtiqueta{" +
                "usuario_id=" + usuario_id +
                ", oferta_id=" + oferta_id +
                '}';
    }
}
