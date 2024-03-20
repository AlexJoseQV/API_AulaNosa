package es.aulanosa.api.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ListaUsuarioOfertaDTOSalida {

    private List<UsuarioOfertaDTO> usuarios;   // Usuarios
    private List<String> errores; // Mensajes de error que se devolverán
    private Timestamp tiempo; // Instante de tiempo en el que se produjo la operación


}
