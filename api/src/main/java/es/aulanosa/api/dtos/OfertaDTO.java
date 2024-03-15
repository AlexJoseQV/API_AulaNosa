package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DTO para manejar información correspondiente a una oferta
 * @author ALEXJOSE
 */
public class OfertaDTO {

    private int id; // Identificador de la oferta

    private int vacantes; // Número de vacantes disponibles

    private String titulo; // Título de la oferta

    private String estado; // Estado actual de la oferta

    private String descripcion; // Descripción detallada de la oferta

    private Timestamp fecha; // Momento de la oferta

    private List<String> requisitos; // Requisitos necesarios para validar la oferta

    private ArrayList<Byte> imagen; // Imagen de la oferta

    public OfertaDTO() {
    }

    public OfertaDTO(int id, int vacantes, String titulo, String estado, String descripcion, Timestamp fecha, List<String> requisitos, ArrayList<Byte> imagen) {
        this.id = id;
        this.vacantes = vacantes;
        this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.requisitos = requisitos;
        this.imagen = imagen;
    }

    public OfertaDTO(int vacantes, String titulo, String estado, String descripcion, Timestamp fecha, List<String> requisitos, ArrayList<Byte> imagen) {
        this.vacantes = vacantes;
        this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.requisitos = requisitos;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public int getVacantes() {
        return vacantes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public List<String> getRequisitos() {
        return requisitos;
    }

    public ArrayList<Byte> getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public void setRequisitos(List<String> requisitos) {
        this.requisitos = requisitos;
    }

    public void setImagen(ArrayList<Byte> imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "OfertaDTO{" +
                "id=" + id +
                ", vacantes=" + vacantes +
                ", titulo='" + titulo + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", requisitos=" + requisitos +
                ", imagen=" + imagen +
                '}';
    }
}
