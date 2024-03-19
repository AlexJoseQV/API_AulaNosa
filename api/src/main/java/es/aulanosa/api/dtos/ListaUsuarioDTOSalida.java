/**
 * Clase que representa la salida de una operación que devuelve una lista de usuarios
 * con información adicional.
 */
package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ListaUsuarioDTOSalida {
    /**
     * Mensajes de error que se devolverán en caso de que ocurran durante la operación.
     */
    private List<String> errores;

    /**
     * Instante de tiempo en el que se produjo la operación.
     */
    private Timestamp tiempo;

    /**
     * Lista que contiene la información de los usuarios obtenida como resultado de la operación.
     */
    private List<UsuarioDTO> usuarios;

    /**
     * Constructor por defecto.
     */
    public ListaUsuarioDTOSalida() {
    }

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param errores   Mensajes de error que se devolverán.
     * @param tiempo    Instante de tiempo en el que se produjo la operación.
     * @param usuarios  Lista con la información de los usuarios.
     */
    public ListaUsuarioDTOSalida(List<String> errores, Timestamp tiempo, List<UsuarioDTO> usuarios) {
        this.errores = errores;
        this.tiempo = tiempo;
        this.usuarios = usuarios;
    }

    /**
     * Obtiene los mensajes de error.
     *
     * @return Lista de mensajes de error.
     */
    public List<String> getErrores() {
        return errores;
    }

    /**
     * Establece los mensajes de error.
     *
     * @param errores Lista de mensajes de error.
     */
    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    /**
     * Obtiene el instante de tiempo en el que se produjo la operación.
     *
     * @return Instante de tiempo.
     */
    public Timestamp getTiempo() {
        return tiempo;
    }

    /**
     * Establece el instante de tiempo en el que se produjo la operación.
     *
     * @param tiempo Instante de tiempo.
     */
    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Obtiene la lista de usuarios.
     *
     * @return Lista de usuarios.
     */
    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios.
     *
     * @param usuarios Lista de usuarios.
     */
    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Devuelve una representación en forma de cadena de la clase.
     *
     * @return Cadena que representa la clase.
     */
    @Override
    public String toString() {
        return "ListaUsuarioDTOSalida{" +
                "errores=" + errores +
                ", tiempo=" + tiempo +
                ", usuarios=" + usuarios +
                '}';
    }
}
