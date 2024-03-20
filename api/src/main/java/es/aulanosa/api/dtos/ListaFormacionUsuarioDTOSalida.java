package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ListaFormacionUsuarioDTOSalida {

    private List<FormacionUsuarioDTO> formacionUsuarioDTOS;

    private List<String> errores;
    private Timestamp tiempo;

    public ListaFormacionUsuarioDTOSalida() {
    }

    public ListaFormacionUsuarioDTOSalida(List<FormacionUsuarioDTO> formacionUsuarioDTOS, List<String> errores, Timestamp tiempo) {
        this.formacionUsuarioDTOS = formacionUsuarioDTOS;
        this.errores = errores;
        this.tiempo = tiempo;
    }

    public List<FormacionUsuarioDTO> getFormacionUsuarioDTOS() {
        return formacionUsuarioDTOS;
    }

    public void setFormacionUsuarioDTOS(List<FormacionUsuarioDTO> formacionUsuarioDTOS) {
        this.formacionUsuarioDTOS = formacionUsuarioDTOS;
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
        return "ListaFormacionUsuarioSalida{" +
                "formacionUsuarioDTOS=" + formacionUsuarioDTOS +
                ", errores=" + errores +
                ", tiempo=" + tiempo +
                '}';
    }
}
