package es.aulanosa.api.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase DTO para manejar información correspondiente a aspectos de un Usuario
 * @author ALEXJOSE
 */
public class UsuarioDTO {
    private Integer id; // Identificador del usuario
    @NotNull(message = "El usuario no puede ser nulo")
    @Size(max = 64, message = "El usuario no puede superar los 64 caracteres")
    private String usuario; // Nombre de usuario
    @NotNull(message = "La contrasena no puede ser nulo")
    @Size(max = 64, message = "La contrasena no puede superar los 64 caracteres")
    private String contrasena; // Contrasena asociada al usuario
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(max = 64, message = "El nombre no puede superar los 64 caracteres")
    private String nombre; // Nombre real del usuario
    @NotNull(message = "Los apellidos no puede ser nulo")
    @Size(max = 100, message = "Los apellidos no puede superar los 100 caracteres")
    private String apellidos; // Apellidos del usuario
    @NotNull(message = "El email no puede ser nulo")
    @Size(max = 100, message = "El email no puede superar los 100 caracteres")
    private String email; // Email del usuario
    @NotNull(message = "El telefono no puede ser nulo")
    @Size(max = 64, message = "El telefono no puede superar los 64 caracteres")
    private String telefono; // Teléfono de contacto del usuario
    private Timestamp actualizacion; // Momento de actualización
    @NotNull(message = "El estado no puede ser nulo")
    @Size(max = 100, message = "El estado no puede superar los 100 caracteres")
    private String estado; // Estado del usuario
    private List<Byte> imagen; // Array de bytes que representan la foto de perfil

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String usuario, String contrasena, String nombre, String apellidos, String email, String telefono, Timestamp actualizacion, String estado, List<Byte> imagen) {
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

    public Integer getId() {
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

    public String getApellidos() {
        return apellidos;
    }

    public List<Byte> getImagen() {
        return imagen;
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

    public String getEstado() {
        return estado;
    }

    public void setImagen(List<Byte> imagen) {
        this.imagen = imagen;
    }

    public void setId(Integer id) {
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
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
