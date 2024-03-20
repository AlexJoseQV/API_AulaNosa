package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

/**
 * Clase empleada como entidad para mapear la información correspondiente de la tabla OfertaEtiqueta
 * @author RubénC
 */
@Table(name = "ofertas_etiquetas")
@Entity
public class OfertaEtiqueta {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id; //identificador de ofertasEtiquetas//

    @Column(name = "etiqueta_id")
    private int etiquetaId; //identificador de etiqueta//
    @Column(name = "oferta_id")
    private int ofertaId; //identificador de oferta//

    /**
     * constructor completo
     * @Param usuario_id es el identificador de etiquetas
     * @Param oferta_id es el identificador de las ofertas
     */

    public OfertaEtiqueta(int id, int etiquetaId, int ofertaId) {
        this.id = id;
        this.etiquetaId = etiquetaId;
        this.ofertaId = ofertaId;
    }

    /**
     * constructor vacío
     */

    public OfertaEtiqueta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(int etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    /**
     * Método toString
     * @return cadena con los identificadores de usuario y ofertas
     */

    @Override
    public String toString() {
        return "OfertaEtiqueta{" +
                "id=" + id +
                ", etiquetaId=" + etiquetaId +
                ", ofertaId=" + ofertaId +
                '}';
    }
}
