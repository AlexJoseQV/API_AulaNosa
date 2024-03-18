package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase DTO para manejar información a devolver correspondiente a una lista de usuarios
 * @author ALEXJOSE
 */
public class ListaUsuarioDTOSalida {

    private List<String> errores; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación
    private List<UsuarioDTO> usuarios; // Lista con la información de los usuarios

    public ListaUsuarioDTOSalida() {
    }

    public ListaUsuarioDTOSalida(List<String> errores, Timestamp tiempo, List<UsuarioDTO> usuarios) {
        this.errores = errores;
        this.tiempo = tiempo;
        this.usuarios = usuarios;
    }

    public List<String> getErrores() {
        return errores;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "ListaUsuarioDTOSalida{" +
                "errores=" + errores +
                ", tiempo=" + tiempo +
                ", usuarios=" + usuarios +
                '}';
    }


}
