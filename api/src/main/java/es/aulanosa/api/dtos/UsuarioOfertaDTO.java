package es.aulanosa.api.dtos;

public class UsuarioOfertaDTO {

    private OfertaDTO oferta;
    private boolean inscrito;
    private boolean interesado;

    public UsuarioOfertaDTO() {
    }

    public UsuarioOfertaDTO(OfertaDTO oferta, boolean inscrito, boolean interesado) {
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
        return "UsuarioOfertaDTO{" +
                "oferta=" + oferta +
                ", inscrito=" + inscrito +
                ", interesado=" + interesado +
                '}';
    }
}
