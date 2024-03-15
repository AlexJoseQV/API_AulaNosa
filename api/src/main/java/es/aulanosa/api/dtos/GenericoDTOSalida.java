package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * Clase DTO para devolver información correspondiente a aspectos genéricos
 * @author ALEXJOSE
 */
public class GenericoDTOSalida {

    private List<String> mensajes; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación

    public GenericoDTOSalida() {
    }

    public GenericoDTOSalida(List<String> mensajes, Timestamp tiempo) {
        this.mensajes = mensajes;
        this.tiempo = tiempo;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "GenericoDTOSalida{" +
                "mensajes=" + mensajes +
                ", tiempo=" + tiempo +
                '}';
    }

}
