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

    private int formacionId;
    private String estado;

    public UsuarioFormacion() {
    }

    public UsuarioFormacion(int id, int usuario_id, int formacionId, String estado) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.formacionId = formacionId;
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
    @Column(name = "formacion_id")
    public int getFormacionId() {
        return formacionId;
    }

    public void setFormacionId(int formacionId) {
        this.formacionId = formacionId;
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
                ", formacionId=" + formacionId +
                ", estado='" + estado + '\'' +
                '}';
    }
}
