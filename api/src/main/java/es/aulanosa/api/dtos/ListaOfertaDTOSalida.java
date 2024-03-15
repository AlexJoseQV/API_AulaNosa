package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase DTO para manejar información a devolver correspondiente a una lista de ofertas
 * @author ALEXJOSE
 */
public class ListaOfertaDTOSalida {
    private List<String> errores; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación
    private List<OfertaDTO> ofertas; // Lista con la información de las ofertas

    public ListaOfertaDTOSalida() {
    }

    public ListaOfertaDTOSalida(List<String> errores, Timestamp tiempo, List<OfertaDTO> ofertas) {
        this.errores = errores;
        this.tiempo = tiempo;
        this.ofertas = ofertas;
    }

    public List<String> getErrores() {
        return errores;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public List<OfertaDTO> getOfertas() {
        return ofertas;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public void setOfertas(List<OfertaDTO> ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public String toString() {
        return "ListaOfertaDTOSalida{" +
                "errores=" + errores +
                ", tiempo=" + tiempo +
                ", ofertas=" + ofertas +
                '}';
    }
}
