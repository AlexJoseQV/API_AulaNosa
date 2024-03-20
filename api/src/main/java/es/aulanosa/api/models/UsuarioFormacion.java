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
    private int usuarioId;

    private int formacionId;
    private String estado;

    public UsuarioFormacion() {
    }

    public UsuarioFormacion(int id, int usuarioId, int formacionId, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.formacionId = formacionId;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "usuario_id")
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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
                ", usuarioId=" + usuarioId +
                ", formacionId=" + formacionId +
                ", estado='" + estado + '\'' +
                '}';
    }
}
