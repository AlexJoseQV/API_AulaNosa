package es.aulanosa.api.services;

import es.aulanosa.api.dtos.AccesoDTO;
import es.aulanosa.api.dtos.UsuarioDTOSalida;
import es.aulanosa.api.models.FormacionDTO;

import java.util.ArrayList;

public interface FormacionService {

    /**
     * Interface para establecer los métodos para la comunicación y lógica entre los controladores de Formacion y la base de datos
     *
     * @author Martin Carballo
     */
    public interface UsuarioService {
        /**
         * Se define un método que devuelve una lista de FormacionDTO
         *
         * @return ArrayList de FormacionDTO
         */
        ArrayList<FormacionDTO> listarFormaciones();
    }

}
