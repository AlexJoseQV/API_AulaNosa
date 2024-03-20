package es.aulanosa.api.models;

import jakarta.persistence.*;

/**
 * clase model de FormacionEtiqueta
 */
@Entity
@Table(name = "formaciones_etiquetas")
public class FormacionEtiqueta {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
   @Column(name = "formacion_id")
    private int formacionId;
    @Column(name = "etiqueta_id")
    private int etiquetaId;

    public FormacionEtiqueta() {
    }

    public FormacionEtiqueta(int id, int formacionId, int etiquetaId) {
        this.id = id;
        this.formacionId = formacionId;
        this.etiquetaId = etiquetaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormacionId() {
        return formacionId;
    }

    public void setFormacionId(int formacionId) {
        this.formacionId = formacionId;
    }

    public int getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(int etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    @Override
    public String toString() {
        return "FormacionEtiqueta{" +
                "id=" + id +
                ", formacionId=" + formacionId +
                ", etiquetaId=" + etiquetaId +
                '}';
    }
}
