package es.aulanosa.api.dtos;

public class NovedadDTO {

    // Atributos
    private ListaOfertaDTOSalida ofertas; // Atributo para almacenar la lista de ofertas
    // Se añadira la lista de formaciones una vez Manuel las tenga

    // Constructor vacío
    public NovedadDTO() {
    }

    // Constructor con parámetro para inicializar ofertas
    public NovedadDTO(ListaOfertaDTOSalida ofertas) {
        this.ofertas = ofertas;
    }

    // Getters y Setters
    public ListaOfertaDTOSalida getOfertas() {
        return ofertas;
    }

    public void setOfertas(ListaOfertaDTOSalida ofertas) {
        this.ofertas = ofertas;
    }

    // Método toString() para obtener una representación en cadena de la clase
    @Override
    public String toString() {
        return "NovedadDTO{" +
                "ofertas=" + ofertas +
                '}';
    }
}
