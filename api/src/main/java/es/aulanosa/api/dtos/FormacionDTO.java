package es.aulanosa.api.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FormacionDTO {

    private  Integer id ;
    @NotNull(message = "El titulo no puede ser nulo")
    @Size(max = 100, message = "El titulo no puede superar los 100 caracteres")
    private String titulo;
    @NotNull(message = "La descripcion no puede ser nulo")
    @Size(max = 100, message = "La descripcion no puede superar los 500 caracteres")
    private String descripcion;
    @NotNull(message = "Los requisitos no puede ser nulo")
    @Size(max = 100, message = "Los requisitos no puede superar los 500 caracteres")
    private List<String> requisitos;
    @NotNull(message = "El inicio no puede ser nulo")
    private Date inicio;
    @NotNull(message = "El fin no puede ser nulo")
    private Date fin ;
    @NotNull(message = "El coste no puede ser nulo")
    private Integer coste;
    @NotNull(message = "El estado no puede ser nulo")
    private String estado;
    private ArrayList<Byte> imagen;
    private Timestamp fecha;

    public FormacionDTO() {
    }

    public FormacionDTO(Integer id, String titulo, String descripcion, List<String> requisitos, Date inicio, Date fin, Integer coste, String estado, ArrayList<Byte> imagen, Timestamp fecha) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.estado = estado;
        this.imagen = imagen;
        this.fecha = fecha;
    }

    public FormacionDTO(String titulo, String descripcion, List<String> requisitos, Date inicio, Date fin, Integer coste, String estado, ArrayList<Byte> imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.estado = estado;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<String> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<String> requisitos) {
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

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "FormacionesDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", requisitos=" + requisitos +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", coste=" + coste +
                ", estado='" + estado + '\'' +
                ", imagen=" + imagen +
                ", fecha=" + fecha +
                '}';
    }
}
