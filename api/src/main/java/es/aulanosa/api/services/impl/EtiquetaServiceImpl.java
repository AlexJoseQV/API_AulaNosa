package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.EtiquetaDTO;
import es.aulanosa.api.dtos.GenericoDTOSalida;
import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.mappers.EtiquetaMapper;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.models.UsuarioEtiqueta;
import es.aulanosa.api.repositories.EtiquetaRepository;
import es.aulanosa.api.repositories.UsuarioEtiquetaRepository;
import es.aulanosa.api.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase contiene métodos para las etiquetas
 * @author MATHIAS
 */
@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Autowired
    private UsuarioEtiquetaRepository usuarioEtiquetaRepository;

    /**
     * Este método permite listar las etiquetas
     * @return objeto listaEtiquetaDTOSalida
     */
    @Override
    public ListaEtiquetaDTOSalida listarEtiquetas() {
        List<String> errores = new ArrayList<>();
        try {
            return new ListaEtiquetaDTOSalida(EtiquetaMapper.convertirALista(etiquetaRepository.findAll()),errores, new Timestamp(System.currentTimeMillis()));
        }catch (Exception e){
            errores.add("Hubo un error");
        }

        return new ListaEtiquetaDTOSalida(new ArrayList<>(),errores,new Timestamp(System.currentTimeMillis()));

    }
    /**
     * Este método permite listar las etiquetas por el identificador de usuario
     * @return objeto listaEtiquetaDTOSalida
     */
    @Override
    public ListaEtiquetaDTOSalida listarInteresesUsuario(int id) {
        List<String> errores = new ArrayList<>();
        try {
            return new ListaEtiquetaDTOSalida(EtiquetaMapper.convertirALista(etiquetaRepository.findById(id)),errores, new Timestamp(System.currentTimeMillis()));
        }catch (Exception e){
            errores.add("Hubo un error");
            e.printStackTrace();
        }

        return new ListaEtiquetaDTOSalida(new ArrayList<>(),errores,new Timestamp(System.currentTimeMillis()));
    }

    /**
     * Método que permite eliminar las etiquetas de un usuario
     * @param id identificador del usuario
     * @return Objeto de la clase GenericoDTOSalida con la información general
     */
    @Override
    public GenericoDTOSalida eliminarInteresesUsuario(int id) {
        List<String> errores = new ArrayList<>();
        try {
            etiquetaRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            errores.add("Hubo un error");
        }
        return new GenericoDTOSalida(errores,new Timestamp(System.currentTimeMillis()));
    }

    /**
     * Método para crear intereses
     * @param id identificador del usuario
     * @param etiqueta identificador de la etiqueta
     * @return Objeto genérico
     */
    @Override
    public GenericoDTOSalida crearInteres(int id, EtiquetaDTO etiqueta) {

        List<String> errores = new ArrayList<>();
        try{
            etiquetaRepository.insertar(id,etiqueta.getId());

        }catch (Exception e) {
            e.printStackTrace();
            errores.add("Hubo un error");

        }

        return new GenericoDTOSalida(errores,new Timestamp(System.currentTimeMillis()));

    }

    /**
     * Método empleado para eliminar la relación de una etiqueta con un usuario
     * @param idUsuario Identificador del usuario
     * @param idEtiqueta Identificador de la etiqueta
     * @return Se devuelve un indicador para mostrar si la operación se realizó correctamente
     */
    @Override
    public GenericoDTOSalida eliminarEtiquetaDeUsuario(int idUsuario, int idEtiqueta){
        List<String> errores = new ArrayList<>();
        try {
            // Se intenta obtener la instancia
            Optional<UsuarioEtiqueta> usuarioEtiquetaOpcional = usuarioEtiquetaRepository.findByUsuarioIdAndEtiquetaId(idUsuario, idEtiqueta);

            if (usuarioEtiquetaOpcional.isPresent()) {
                // La instancia existe, entonces eliminarla
                UsuarioEtiqueta usuarioEtiqueta = usuarioEtiquetaOpcional.get();
                usuarioEtiquetaRepository.delete(usuarioEtiqueta);
            }else{
                errores.add("Error no existe la etiqueta indicada para ese usuario");
            }
        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new GenericoDTOSalida(errores, new Timestamp(System.currentTimeMillis()));
    }
}
