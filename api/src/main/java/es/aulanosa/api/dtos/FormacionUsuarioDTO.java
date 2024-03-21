package es.aulanosa.api.dtos;


public class FormacionUsuarioDTO {

    private FormacionDTO formacionDTO;
    private boolean inscrito;
    private boolean interesado;

    public FormacionUsuarioDTO() {
    }

    public FormacionUsuarioDTO(FormacionDTO formacionDTO, boolean inscrito, boolean interesado) {
        this.formacionDTO = formacionDTO;
        this.inscrito = inscrito;
        this.interesado = interesado;
    }

    public FormacionDTO getFormacionDTO() {
        return formacionDTO;
    }

    public void setFormacionDTO(FormacionDTO formacionDTO) {
        this.formacionDTO = formacionDTO;
    }

    public boolean isInscrito() {
        return inscrito;
    }

    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
    }

    public boolean isInteresado() {
        return interesado;
    }

    public void setInteresado(boolean interesado) {
        this.interesado = interesado;
    }

    @Override
    public String toString() {
        return "FormacionUsuarioDTO{" +
                "formacionDTO=" + formacionDTO +
                ", inscrito=" + inscrito +
                ", interesado=" + interesado +
                '}';
    }
}
