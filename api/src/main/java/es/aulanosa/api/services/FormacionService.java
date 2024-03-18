package es.aulanosa.api.services;

import es.aulanosa.api.dtos.FormacionDTO;
import es.aulanosa.api.dtos.FormacionDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSailda;

/**
 * interfaz para los metodos que usara FormacionService
 */
public interface FormacionService {

    public ListaFormacionDTOSailda listarFormaciones() ;

    public FormacionDTOSalida obtenerFormacion(int idFormacion);
}
