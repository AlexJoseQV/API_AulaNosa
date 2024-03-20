package es.aulanosa.api.services.impl;
/**
 * clase con los metodos para las formaciones
 */

import es.aulanosa.api.dtos.*;
import es.aulanosa.api.mappers.EtiquetaMapper;
import es.aulanosa.api.mappers.FormacionMapper;
import es.aulanosa.api.mappers.UsuarioMapper;
import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.models.UsuarioEtiqueta;
import es.aulanosa.api.models.UsuarioFormacion;
import es.aulanosa.api.repositories.FormacionRepository;
import es.aulanosa.api.repositories.UsuarioEtiquetaRepository;
import es.aulanosa.api.repositories.UsuarioFormacionRepository;
import es.aulanosa.api.repositories.UsuarioRepository;
import es.aulanosa.api.services.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    private FormacionRepository formacionRepository;
    @Autowired
    private UsuarioFormacionRepository usuarioFormacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public ListaFormacionDTOSalida listarFormaciones() {

        List<String> errores = new ArrayList<>();
        List<Formacion> formaciones = new ArrayList<>();
        try {

            formaciones = formacionRepository.findAll();

            return new ListaFormacionDTOSalida(FormacionMapper.convertiraLista(formaciones), new Timestamp(System.currentTimeMillis()) , errores);


        }catch (Exception e){
            errores.add("Error con la base de datos");
        }



        return new ListaFormacionDTOSalida(FormacionMapper.convertiraLista(formaciones), new Timestamp(System.currentTimeMillis()) , errores);
    }

    @Override
    public FormacionDTOSalida obtenerFormacion(int idFormacion) {


        List<String> errores = new ArrayList<>();
        Formacion formacion = new Formacion();
        try {

            Optional<Formacion> formacionRec = formacionRepository.findById(idFormacion);
            if (formacionRec.isPresent()){
                formacion=formacionRec.get();
            }

            return new FormacionDTOSalida(FormacionMapper.convertiraDTO(formacion), new Timestamp(System.currentTimeMillis()) , errores);


        }catch (Exception e){
            errores.add("Error con la base de datos");
        }



        
        return new FormacionDTOSalida(FormacionMapper.convertiraDTO(formacion), new Timestamp(System.currentTimeMillis()) , errores);


    }

    /**
     * metodo para la busqueda de usuarios incritos en una formacion
     * @param formacionId id de la formacion
     * @return lista de usuarios incritos
     */
    @Override
    public ListaUsuarioDTOSalida obtenerUsuariosFormacion(int formacionId) {

        List<String> errores = new ArrayList<>();
        ListaUsuarioDTOSalida listaUsuarioDTOSalida = new ListaUsuarioDTOSalida();
        List<UsuarioDTO> usuarios = new ArrayList<>();

        try {

            List<UsuarioFormacion> usuarioFormacionRec =usuarioFormacionRepository.findAllByFormacionId(formacionId);

            for (int i =0 ; i <usuarioFormacionRec.size(); i++){

               if (usuarioFormacionRec.get(i).getEstado().equals("INSCRITO")){

                   Usuario user = usuarioRepository.getById(usuarioFormacionRec.get(i).getUsuario_id());

                   usuarios.add(UsuarioMapper.convertirADTO(user));
               }

            }


            return new ListaUsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()), usuarios);


        }catch (Exception e){
            errores.add("Error con la base de datos");
        }


        return new ListaUsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()),usuarios );
    }

    /**
     * Este método permite inscribir un usuario en una formación
     * @param id id de la formación
     * @param idUsuario id del Usuario
     * @param estado estadod de la inscripción
     * @return objeto de la clase GenericoDTOSalida con la información general
     */
    @Override
    public GenericoDTOSalida insribirUsuario(int id, int idUsuario,String estado) {
        List<String> errores = new ArrayList<>();
        try {
            usuarioFormacionRepository.insertar(idUsuario, id, estado);
        } catch (Exception e) {
            errores.add("Hubo un error");

        }
        return new GenericoDTOSalida(errores, new Timestamp(System.currentTimeMillis()));
    }

    /**
     * metodo para la creacion de una formacion en bd
     * @param formacionDTO formacion a introducir en la bd
     * @return devuelve la informacion de la formacion introducida en bd
     */
    @Override
    public FormacionDTOSalida crearFormacion(FormacionDTO formacionDTO) {

        List<String> errores = new ArrayList<>();
        Formacion formacion = new Formacion();


        try {

            formacionDTO.setFecha(new Timestamp(System.currentTimeMillis()));
            formacionRepository.save(FormacionMapper.convertirAModel(formacionDTO));
            Optional<Formacion> formacionRec = formacionRepository.findByTitulo(formacionDTO.getTitulo());

            if (formacionRec.isPresent()){

                formacion = formacionRec.get();
            }



            return new FormacionDTOSalida(FormacionMapper.convertiraDTO(formacion), new Timestamp(System.currentTimeMillis()), errores);


        }catch (Exception e){
            errores.add("Error con la base de datos");
        }


        return new FormacionDTOSalida(FormacionMapper.convertiraDTO(formacion), new Timestamp(System.currentTimeMillis()), errores);

    }

    /**
     * Este método permite quitar un usuario de una formación
     * @param id identificador del usuario
     * @param formacionId identificador de la formación
     * @return Objeto de la clase GenericoDTOSalida con al información general de un error
     */
    @Override
    public GenericoDTOSalida eliminarUsuarioFormacion(int id, int formacionId) {
        List<String> errores = new ArrayList<>();
        try {
            usuarioFormacionRepository.deleteById(id,formacionId);
        } catch (Exception e) {
            errores.add("Hubo un error");

        }
        return new GenericoDTOSalida(errores, new Timestamp(System.currentTimeMillis()));
    }


}
