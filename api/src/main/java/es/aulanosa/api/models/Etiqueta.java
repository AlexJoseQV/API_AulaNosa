package es.aulanosa.api.models;

import jakarta.persistence.*;

/**
 * Esta clase representa una etiqueta
 */
@Entity
@Table(name = "etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    /**
     * Constructor vacío
     */
    public Etiqueta() {
    }

    /**
     * Constructor completo
     * @param id identificador de la etiqueta
     * @param nombre nombre de la etiqueta
     */
    public Etiqueta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método toString
     * @return cadena con la información de la etiqueta
     */
    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
