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
    private int etiqueta_id;

    public FormacionEtiqueta() {
    }

    public FormacionEtiqueta(int id, int formacionId, int etiqueta_id) {
        this.id = id;
        this.formacionId = formacionId;
        this.etiqueta_id = etiqueta_id;
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

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    @Override
    public String toString() {
        return "FormacionEtiqueta{" +
                "id=" + id +
                ", formacionId=" + formacionId +
                ", etiqueta_id=" + etiqueta_id +
                '}';
    }
}
