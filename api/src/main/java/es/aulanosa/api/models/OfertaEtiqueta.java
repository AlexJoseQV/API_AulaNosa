package es.aulanosa.api.models;

public class OfertaEtiqueta {

    private int usuarioId; //identificador de usuario//

    private int ofertaId; //identificador de oferta//

    public OfertaEtiqueta(int usuarioId, int ofertaId) {
        this.usuarioId = usuarioId;
        this.ofertaId = ofertaId;
    }

    public OfertaEtiqueta() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    @Override
    public String toString() {
        return "OfertaEtiqueta{" +
                "usuarioId=" + usuarioId +
                ", ofertaId=" + ofertaId +
                '}';
    }
}
