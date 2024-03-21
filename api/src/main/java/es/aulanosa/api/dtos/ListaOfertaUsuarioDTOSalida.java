package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ListaOfertaUsuarioDTOSalida {

    private List<OfertaUsuarioDTO> ofertaUsuarioDTOS;

    private List<String> errores;
    private Timestamp tiempo;

    public ListaOfertaUsuarioDTOSalida() {}

    public ListaOfertaUsuarioDTOSalida(List<OfertaUsuarioDTO> ofertaUsuarioDTOS, List<String> errores, Timestamp tiempo) {
        this.ofertaUsuarioDTOS = ofertaUsuarioDTOS;
        this.errores = errores;
        this.tiempo = tiempo;
    }

    public List<OfertaUsuarioDTO> getOfertaUsuarioDTOS() {
        return ofertaUsuarioDTOS;
    }

    public void setOfertaUsuarioDTOS(List<OfertaUsuarioDTO> ofertaUsuarioDTOS) {
        this.ofertaUsuarioDTOS = ofertaUsuarioDTOS;
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
        return "ListaOfertaUsuarioDTOSalida{" +
                "ofertaUsuarioDTOS=" + ofertaUsuarioDTOS +
                ", errores=" + errores +
                ", tiempo=" + tiempo +
                '}';
    }
}
