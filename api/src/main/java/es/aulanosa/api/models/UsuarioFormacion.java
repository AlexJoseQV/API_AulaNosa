package es.aulanosa.api.models;

import jakarta.persistence.*;

/**
 * clase model de UsuarioFormacion
 */
@Entity
@Table(name = "inscripciones_formaciones")
public class UsuarioFormacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int usuario_id;
    private int formacion_id;
    private String estado;

    public UsuarioFormacion() {
    }

    public UsuarioFormacion(int id, int usuario_id, int formacion_id, String estado) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.formacion_id = formacion_id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getFormacion_id() {
        return formacion_id;
    }

    public void setFormacion_id(int formacion_id) {
        this.formacion_id = formacion_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioFormacion{" +
                "id=" + id +
                ", usuario_id=" + usuario_id +
                ", formacion_id=" + formacion_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
