package es.aulanosa.api.dtos;

public class OfertaUsuarioDTO {

    private OfertaDTO oferta;
    private boolean inscrito;
    private boolean interesado;

    public OfertaUsuarioDTO() {}

    public OfertaUsuarioDTO(OfertaDTO oferta, boolean inscrito, boolean interesado) {
        this.oferta = oferta;
        this.inscrito = inscrito;
        this.interesado = interesado;
    }

    public OfertaDTO getOferta() {
        return oferta;
    }

    public void setOferta(OfertaDTO oferta) {
        this.oferta = oferta;
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
        return "OfertaUsuarioDTO{" +
                "oferta=" + oferta +
                ", inscrito=" + inscrito +
                ", interesado=" + interesado +
                '}';
    }
}
