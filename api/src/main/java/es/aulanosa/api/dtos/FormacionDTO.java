package es.aulanosa.api.dtos;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * clase DTO de Formacion
 */

public class FormacionDTO {

    private int id ;
    private String titulo;
    private String descripcion;
    private String requisitos;
    private Date inicio;
    private Date fin;
    private Timestamp fecha;
    private int coste;
    private String estado;
    private ArrayList<Byte> imagen;

    public FormacionDTO() {
    }

    public FormacionDTO(int id, String titulo, String descripcion, String requisitos, Date inicio, Date fin, Timestamp fecha, int coste, String estado, ArrayList<Byte> imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.estado = estado;
        this.imagen = imagen;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getCoste() {
        return coste;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public void setCoste(int coste) {
        this.coste = coste;
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

    @Override
    public String toString() {
        return "FormacionDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", requisitos='" + requisitos + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", fecha" + fecha +
                ", coste=" + coste +
                ", estado='" + estado + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
