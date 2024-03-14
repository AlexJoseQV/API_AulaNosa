package es.aulanosa.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "formaciones_etiquetas")
public class FormacionEtiqueta {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private int formacion_id;
    private int etiqueta_id;

    public FormacionEtiqueta() {
    }

    public FormacionEtiqueta(int id, int formacion_id, int etiqueta_id) {
        this.id = id;
        this.formacion_id = formacion_id;
        this.etiqueta_id = etiqueta_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormacion_id() {
        return formacion_id;
    }

    public void setFormacion_id(int formacion_id) {
        this.formacion_id = formacion_id;
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
                ", formacion_id=" + formacion_id +
                ", etiqueta_id=" + etiqueta_id +
                '}';
    }
}
