package es.aulanosa.api.services;

import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSalida;
import es.aulanosa.api.dtos.ListaUsuarioDTOSalida;

/**
 * interfaz para los metodos que usara FormacionService
 */
public interface FormacionService {

    public ListaFormacionDTOSalida listarFormaciones() ;
    public FormacionDTOSalida obtenerFormacion(int idFormacion);
    public ListaUsuarioDTOSalida obtenerUsuariosFormacion(int idFormacion);


}
