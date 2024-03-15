package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * Esta clase representa una etiqueta la cuál se devolverá desde la api
 */
public class ListaEtiquetaDTOSalida {
    private List<EtiquetaDTO> etiquetas;
    private List <String> errores;
    private Timestamp tiempo;

    /**
     * Constructor vacío
     */
    public ListaEtiquetaDTOSalida() {
    }

    /**
     * Constructor completo
     * @param etiquetas lista de objetos EtiquetaDTO
     * @param errores lista con los errores que hayan ocurrido
     * @param tiempo Fecha y hora en la que ocurrió el error
     */
    public ListaEtiquetaDTOSalida(List<EtiquetaDTO> etiquetas, List<String> errores, Timestamp tiempo) {
        this.etiquetas = etiquetas;
        this.errores = errores;
        this.tiempo = tiempo;
    }

    public List<EtiquetaDTO> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<EtiquetaDTO> etiquetas) {
        this.etiquetas = etiquetas;
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

    /**
     * Método toString
     * @return cadena con la información de la etiqueta de salida
     */
    @Override
    public String toString() {
        return "EtiquetaDTOSalida{" +
                "etiquetas=" + etiquetas +
                ", errores=" + errores +
                ", tiempo=" + tiempo +
                '}';
    }
}
