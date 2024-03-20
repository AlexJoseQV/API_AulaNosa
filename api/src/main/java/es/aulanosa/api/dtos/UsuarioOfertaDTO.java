package es.aulanosa.api.dtos;

import es.aulanosa.api.models.Oferta;

public class UsuarioOfertaDTO {

    private Oferta oferta;
    private boolean inscrito;
    private boolean interesado;

    public UsuarioOfertaDTO() {
    }

    public UsuarioOfertaDTO(Oferta oferta, boolean inscrito, boolean interesado) {
        this.oferta = oferta;
        this.inscrito = inscrito;
        this.interesado = interesado;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
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
