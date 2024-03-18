package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

/**
 * clase model de salida de una Formacion
 */
public class FormacionDTOSalida {
    private FormacionDTO formacionDTO;
    private Timestamp tiempo;
    private List<String> errores;

    public FormacionDTOSalida() {
    }

    public FormacionDTOSalida(FormacionDTO formacionDTO, Timestamp tiempo, List<String> errores) {
        this.formacionDTO = formacionDTO;
        this.tiempo = tiempo;
        this.errores = errores;
    }

    public FormacionDTO getFormacionDTO() {
        return formacionDTO;
    }

    public void setFormacionDTO(FormacionDTO formacionDTO) {
        this.formacionDTO = formacionDTO;
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
        return "FormacionDTOSalida{" +
                "formacionDTO=" + formacionDTO +
                ", tiempo=" + tiempo +
                ", errores=" + errores +
                '}';
    }
}
