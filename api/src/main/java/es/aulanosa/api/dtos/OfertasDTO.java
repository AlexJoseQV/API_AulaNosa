package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Clase DTO para manejar información correspondiente a las ofertas
 * @author RubénC
 */
public class OfertasDTO {

    private int id; //Identificador de la oferta

    private String titulo; //Nombre de la oferta

    private String descripcion; //Explicación de la oferta

    private String requisitos; //Cualidades necesarias para aplicar a la oferta

    private int vacantes; //Número de vacantes restantes

    private String estado;//Información de si la oferta está activa o no

    private ArrayList<Byte> imagen; //Imagen de la empresa de la oferta

    private Timestamp fecha; // Fecha de la publicación de la oferta

    public OfertasDTO() {
    }

    public OfertasDTO(int id, String titulo, String descripcion, String requisitos, int vacantes, String estado, ArrayList<Byte> imagen, Timestamp fecha) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.vacantes = vacantes;
        this.estado = estado;
        this.imagen = imagen;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Byte> getImagen() {
        return imagen;
    }

    public void setImagen(ArrayList<Byte> imagen) {
        this.imagen = imagen;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "OfertaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", requisitos='" + requisitos + '\'' +
                ", vacantes=" + vacantes +
                ", estado='" + estado + '\'' +
                ", imagen=" + imagen +
                ", fecha=" + fecha +
                '}';
    }
}
