package es.aulanosa.api.dtos;

/**
 * Esta clase representa un DTO (Data Transfer Object) para novedades en el sistema.
 * Contiene información sobre ofertas y formaciones.
 */
public class NovedadDTO {

    // Atributos
    private ListaOfertaDTOSalida ofertas; // Atributo para almacenar la lista de ofertas
    private ListaFormacionDTOSalida formaciones; // Atributo para almacenar la lista de formaciones

    // Constructor vacío
    public NovedadDTO() {
    }

    /**
     * Constructor para inicializar una instancia de NovedadDTO con ofertas y formaciones.
     * @param ofertas Lista de ofertas a asignar
     * @param formaciones Lista de formaciones a asignar
     */
    public NovedadDTO(ListaOfertaDTOSalida ofertas, ListaFormacionDTOSalida formaciones) {
        this.ofertas = ofertas;
        this.formaciones = formaciones;
    }

    // Getters y Setters

    /**
     * Obtiene la lista de ofertas.
     * @return La lista de ofertas
     */
    public ListaOfertaDTOSalida getOfertas() {
        return ofertas;
    }

    /**
     * Establece la lista de ofertas.
     * @param ofertas La lista de ofertas a asignar
     */
    public void setOfertas(ListaOfertaDTOSalida ofertas) {
        this.ofertas = ofertas;
    }

    /**
     * Obtiene la lista de formaciones.
     * @return La lista de formaciones
     */
    public ListaFormacionDTOSalida getFormaciones() {
        return formaciones;
    }

    /**
     * Establece la lista de formaciones.
     * @param formaciones La lista de formaciones a asignar
     */
    public void setFormaciones(ListaFormacionDTOSalida formaciones) {
        this.formaciones = formaciones;
    }

    // Método toString() para obtener una representación en cadena de la clase

    /**
     * Devuelve una representación en cadena de la clase NovedadDTO.
     * @return Cadena que representa la clase
     */
    @Override
    public String toString() {
        return "NovedadDTO{" +
                "ofertas=" + ofertas +
                ", formaciones=" + formaciones +
                '}';
    }
}
