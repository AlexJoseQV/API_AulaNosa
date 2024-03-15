package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase DTO para manejar información a devolver correspondiente a una oferta
 * @author ALEXJOSE
 */
public class OfertaDTOSalida {

    private List<String> errores; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación
    private OfertaDTO oferta; // Información de la oferta

    public OfertaDTOSalida() {
    }

    public OfertaDTOSalida(List<String> errores, Timestamp tiempo, OfertaDTO oferta) {
        this.errores = errores;
        this.tiempo = tiempo;
        this.oferta = oferta;
    }

    public List<String> getErrores() {
        return errores;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public OfertaDTO getOferta() {
        return oferta;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public void setOferta(OfertaDTO oferta) {
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "OfertaDTOSalida{" +
                "errores=" + errores +
                ", tiempo=" + tiempo +
                ", oferta=" + oferta +
                '}';
    }
}
