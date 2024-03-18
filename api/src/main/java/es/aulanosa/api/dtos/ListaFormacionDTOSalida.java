package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ListaFormacionDTOSalida {

    List<FormacionDTO> listaFormaciones;
    private Timestamp tiempo;
    private List<String> errores;

    public ListaFormacionDTOSalida() {
    }

    public ListaFormacionDTOSalida(List<FormacionDTO> listaFormaciones, Timestamp tiempo, List<String> errores) {
        this.listaFormaciones = listaFormaciones;
        this.tiempo = tiempo;
        this.errores = errores;
    }

    public List<FormacionDTO> getListaFormaciones() {
        return listaFormaciones;
    }

    public void setListaFormaciones(List<FormacionDTO> listaFormaciones) {
        this.listaFormaciones = listaFormaciones;
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
        return "ListaFormacionDTOSailda{" +
                "listaFormaciones=" + listaFormaciones +
                ", tiempo=" + tiempo +
                ", errores=" + errores +
                '}';
    }
}
