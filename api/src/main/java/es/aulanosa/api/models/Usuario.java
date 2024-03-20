package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase empleada como entidad para mapear la información correspondiente de la tabla usuarios
 * @author ALEXJOSE
 */
@Table(name = "usuarios")
@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id; // Identificador del usuario
    private String usuario; // Nombre de usuario
    private String contrasena; // Contrasena asociada al usuario
    private String nombre; // Nombre real del usuario
    private String apellidos; // Apellidos del usuario
    private String email; // Email del usuario
    private String telefono; // Teléfono de contacto del usuario
    private Timestamp actualizacion; // Momento de actualización
    private String estado; // Estado del usuario
    private List<Byte> imagen; // Array de bytes que representan la foto de perfil

    public Usuario() {
    }

    public Usuario(int id, String usuario, String contrasena, String nombre, String apellidos, String email, String telefono, Timestamp actualizacion, String estado, List<Byte> imagen) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.actualizacion = actualizacion;
        this.estado = estado;
        this.imagen = imagen;
    }

    public Usuario(String usuario, String contrasena, String nombre, String apellidos, String email, String telefono, Timestamp actualizacion, String estado, List<Byte> imagen) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.actualizacion = actualizacion;
        this.estado = estado;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Timestamp getActualizacion() {
        return actualizacion;
    }

    public List<Byte> getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setActualizacion(Timestamp actualizacion) {
        this.actualizacion = actualizacion;
    }

    public void setImagen(List<Byte> imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", actualizacion=" + actualizacion +
                ", estado='" + estado + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
