package es.aulanosa.api.dtos;

import jakarta.validation.constraints.NotNull;

/**
 * Esta clase representa una etiqueta
 * @author MATHIAS
 */
public class EtiquetaDTO {
    @NotNull(message = "El id no puede ser nulo")
    private Integer id;
    private String nombre;

    /**
     * Constructor vacío
     */
    public EtiquetaDTO() {
    }

    /**
     * Constructor completo
     * @param id identificador de la etiqueta
     * @param nombre nombre de la etiqueta
     */
    public EtiquetaDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método toString
     * @return cadena con la información de la etiqueta
     */
    @Override
    public String toString() {
        return "EtiquetaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
