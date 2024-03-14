package es.aulanosa.api.dtos;

/**
 * Clase DTO para manejar información correspondiente al acceso de un Usuario
 * @author ALEXJOSE
 */
public class AccesoDTO {

    String nombre; // Nombre con el que se realizará el acceso
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
