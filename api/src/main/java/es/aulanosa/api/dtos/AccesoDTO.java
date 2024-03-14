package es.aulanosa.api.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase DTO para manejar información correspondiente al acceso de un Usuario
 * @author ALEXJOSE
 */
public class AccesoDTO {

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    String nombre; // Nombre con el que se realizará el acceso
    @NotNull(message = "La contrasena no puede ser nula")
    @Size(max = 64, message = "La contrasena no puede superar los 64 caracteres")
    String contrasena; // Contraseña correspondiente para el acceso

    public AccesoDTO() {
    }

    public AccesoDTO(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "AccesoDTO{" +
                "nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }


}
