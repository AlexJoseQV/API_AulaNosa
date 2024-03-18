package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Table(name = "usuarios_etiquetas")
@Entity
public class UsuarioEtiqueta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int usuario_id; //identificador de usuario//

    private int etiqueta_id; //identificador de etiqueta//


    /**
     * Constructor completo
     * @param id identificador
     * @param usuario_id identificador del usuario
     * @param etiqueta_id identificador de la etiqueta
     */

    public UsuarioEtiqueta(int id, int usuario_id, int etiqueta_id) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.etiqueta_id = etiqueta_id;
    }

    /**
     * Constructor vacío
     */
    public UsuarioEtiqueta() {
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

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    /**
     * Método toString
     * @return cadena con los identificadores de usuario y etiquetas
     */
    @Override
    public String toString() {
        return "UsuarioEtiqueta{" +
                "usuario_id=" + usuario_id +
                ", etiqueta_id=" + etiqueta_id +
                '}';
    }
}
