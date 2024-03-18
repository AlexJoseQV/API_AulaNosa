package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * clase dtoSalida para una lista de usuarios
 */
public class ListaUsuarioDTOSalida {
    private List<UsuarioDTO> usuarios;
    private Timestamp tiempo;
    private List<String> errores;

    public ListaUsuarioDTOSalida() {
    }

    public ListaUsuarioDTOSalida(List<UsuarioDTO> usuarios, Timestamp tiempo, List<String> errores) {
        this.usuarios = usuarios;
        this.tiempo = tiempo;
        this.errores = errores;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    @Override
    public String toString() {
        return "ListaUsuarioDTOSalida{" +
                "usuarios=" + usuarios +
                ", tiempo=" + tiempo +
                ", errores=" + errores +
                '}';
    }
}
