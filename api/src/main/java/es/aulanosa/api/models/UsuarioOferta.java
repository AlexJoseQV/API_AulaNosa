package es.aulanosa.api.models;

import jakarta.persistence.*;

/**
 * Esta clase representa la relación entre un usuario y una oferta.
 */
@Table(name = "inscripciones_ofertas")
@Entity
public class UsuarioOferta {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    /**
     * Identificador del usuario.
     */
    private int usuario_id;

    /**
     * Identificador de la oferta.
     */
    private int oferta_id;

    /**
     * Estado de la relación usuario-oferta.
     */
    private String estado;

    /**
     * Constructor por defecto de la clase UsuarioOferta.
     */
    public UsuarioOferta() {
    }

    /**
     * Constructor con parámetros de la clase UsuarioOferta.
     * @param id Identificador de la relación usuario-oferta.
     * @param usuario_id Identificador del usuario.
     * @param oferta_id Identificador de la oferta.
     * @param estado Estado de la relación usuario-oferta.
     */
    public UsuarioOferta(int id, int usuario_id, int oferta_id, String estado) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.oferta_id = oferta_id;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador de la relación usuario-oferta.
     * @return El identificador de la relación usuario-oferta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la relación usuario-oferta.
     * @param id El identificador de la relación usuario-oferta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del usuario.
     * @return El identificador del usuario.
     */
    public int getUsuario_id() {
        return usuario_id;
    }

    /**
     * Establece el identificador del usuario.
     * @param usuario_id El identificador del usuario.
     */
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * Obtiene el identificador de la oferta.
     * @return El identificador de la oferta.
     */
    public int getOferta_id() {
        return oferta_id;
    }

    /**
     * Establece el identificador de la oferta.
     * @param oferta_id El identificador de la oferta.
     */
    public void setOferta_id(int oferta_id) {
        this.oferta_id = oferta_id;
    }

    /**
     * Obtiene el estado de la relación usuario-oferta.
     * @return El estado de la relación usuario-oferta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la relación usuario-oferta.
     * @param estado El estado de la relación usuario-oferta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación en cadena de la relación usuario-oferta.
     * @return Una representación en cadena de la relación usuario-oferta.
     */
    @Override
    public String toString() {
        return "UsuarioOferta{" +
                "id=" + id +
                ", usuario_id=" + usuario_id +
                ", oferta_id=" + oferta_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
