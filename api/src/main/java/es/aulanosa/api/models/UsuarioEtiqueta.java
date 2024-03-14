package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Table(name = "usuarios_etiquetas")
@Entity
public class UsuarioEtiqueta {

    private int usuario_id; //identificador de usuario//

    private int etiqueta_id; //identificador de etiqueta//

    public int getUsuario_id() {
        return usuario_id;
    }

    public UsuarioEtiqueta(int usuario_id, int etiqueta_id) {
        this.usuario_id = usuario_id;
        this.etiqueta_id = etiqueta_id;
    }

    public UsuarioEtiqueta() {
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    @Override
    public String toString() {
        return "UsuarioEtiqueta{" +
                "usuario_id=" + usuario_id +
                ", etiqueta_id=" + etiqueta_id +
                '}';
    }
}
