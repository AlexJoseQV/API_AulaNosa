package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase DTO para devolver información correspondiente a aspectos de un Usuario
 * @author ALEXJOSE
 */
public class UsuarioDTOSalida {
    private List<String> errores; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación
    private UsuarioDTO usuario; // Información correspondiente del usuario

    public UsuarioDTOSalida() {
    }

    public UsuarioDTOSalida(List<String> errores, Timestamp tiempo, UsuarioDTO usuario) {
        this.errores = errores;
        this.tiempo = tiempo;
        this.usuario = usuario;
    }

    public List<String> getErrores() {
        return errores;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "UsuarioDTOSalida{" +
                "errores=" + errores +
                ", tiempo=" + tiempo +
                ", usuario=" + usuario +
                '}';
    }

}
