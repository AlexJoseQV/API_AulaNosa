package es.aulanosa.api.dtos;
/**
 * Esta clase representa una etiqueta
 * @author MATHIAS
 */
public class EtiquetaDTO {
    private int id;
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
    public EtiquetaDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
