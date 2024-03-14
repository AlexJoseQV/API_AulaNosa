package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Esta clase representa una oferta de empleo.
 */
@Table(name = "ofertas")
@Entity
public class Oferta {

    /**
     * Identificador único de la oferta.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    /**
     * Número de vacantes disponibles en la oferta.
     */
    private int vacantes;

    /**
     * Título de la oferta.
     */
    private String titulo;

    /**
     * Estado actual de la oferta.
     */
    private String estado;

    /**
     * Descripción detallada de la oferta.
     */
    private String descripcion;

    /**
     * Requisitos necesarios para aplicar a la oferta.
     */
    private String requisitos; // Mappear desde ArrayList<EtiquetasDTO>

    /**
     * Imagen asociada a la oferta.
     */
    private ArrayList<Byte> imagen;

    /**
     * Constructor por defecto de la clase Oferta.
     */
    public Oferta() {
    }

    /**
     * Constructor de la clase Oferta.
     */
    public Oferta(int id, int vacantes, String titulo, String estado, String descripcion, String requisitos, ArrayList<Byte> imagen) {
        this.id = id;
        this.vacantes = vacantes;
        this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.imagen = imagen;
    }

    /**
     * Obtiene el identificador de la oferta.
     * @return El identificador de la oferta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la oferta.
     * @param id El identificador de la oferta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el número de vacantes disponibles en la oferta.
     * @return El número de vacantes disponibles.
     */
    public int getVacantes() {
        return vacantes;
    }

    /**
     * Establece el número de vacantes disponibles en la oferta.
     * @param vacantes El número de vacantes disponibles.
     */
    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    /**
     * Obtiene el título de la oferta.
     * @return El título de la oferta.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la oferta.
     * @param titulo El título de la oferta.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el estado actual de la oferta.
     * @return El estado actual de la oferta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la oferta.
     * @param estado El estado actual de la oferta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la descripción detallada de la oferta.
     * @return La descripción detallada de la oferta.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción detallada de la oferta.
     * @param descripcion La descripción detallada de la oferta.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene los requisitos necesarios para aplicar a la oferta.
     * @return Los requisitos necesarios para aplicar a la oferta.
     */
    public String getRequisitos() {
        return requisitos;
    }

    /**
     * Establece los requisitos necesarios para aplicar a la oferta.
     * @param requisitos Los requisitos necesarios para aplicar a la oferta.
     */
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * Obtiene la imagen asociada a la oferta.
     * @return La imagen asociada a la oferta.
     */
    public ArrayList<Byte> getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen asociada a la oferta.
     * @param imagen La imagen asociada a la oferta.
     */
    public void setImagen(ArrayList<Byte> imagen) {
        this.imagen = imagen;
    }

    /**
     * Devuelve una representación en cadena de la oferta.
     * @return Una representación en cadena de la oferta.
     */
    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", vacantes=" + vacantes +
                ", titulo='" + titulo + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", requisitos='" + requisitos + '\'' +
                '}';
    }
}
