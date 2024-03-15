package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class OfertasDTOSalida {

    private List<OfertasDTO> ofertas;
    private List <String> errores;
    private Timestamp tiempo;

    public OfertasDTOSalida() {
    }

    public OfertasDTOSalida(List<OfertasDTO> ofertas, List<String> errores, Timestamp tiempo) {
        this.ofertas = ofertas;
        this.errores = errores;
        this.tiempo = tiempo;
    }

    public List<OfertasDTO> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertasDTO> ofertas) {
        this.ofertas = ofertas;
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
        return "OfertasDTOSalida{" +
                "ofertas=" + ofertas +
                ", errores=" + errores +
                ", tiempo=" + tiempo +
                '}';
    }
}
