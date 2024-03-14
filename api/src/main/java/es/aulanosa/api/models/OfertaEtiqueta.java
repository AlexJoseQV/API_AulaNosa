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

    private int etiqueta_id; //identificador de etiqueta//

    private int oferta_id; //identificador de oferta//

    /**
     * constructor completo
     * @Param usuario_id es el identificador de etiquetas
     * @Param oferta_id es el identificador de las ofertas
     */

    public OfertaEtiqueta(int id, int etiqueta_id, int oferta_id) {
        this.id = id;
        this.etiqueta_id = etiqueta_id;
        this.oferta_id = oferta_id;
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

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
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
                "etiqueta_id=" + etiqueta_id +
                ", oferta_id=" + oferta_id +
                '}';
    }
}
