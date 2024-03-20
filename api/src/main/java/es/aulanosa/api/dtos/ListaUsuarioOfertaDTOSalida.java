package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ListaUsuarioOfertaDTOSalida {

    private List<UsuarioOfertaDTO> usuarios;   // Usuarios
    private List<String> errores; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación

    public ListaUsuarioOfertaDTOSalida() {
    }

    public ListaUsuarioOfertaDTOSalida(List<UsuarioOfertaDTO> usuarios, List<String> errores, Timestamp tiempo) {
        this.usuarios = usuarios;
        this.errores = errores;
        this.tiempo = tiempo;
    }

    public List<UsuarioOfertaDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioOfertaDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "ListaUsuarioOfertaDTOSalida{" +
                "usuarios=" + usuarios +
                ", errores=" + errores +
                ", tiempo=" + tiempo +
                '}';
    }
}
