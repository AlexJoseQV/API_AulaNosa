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
            errores.add("Hubo un error");
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
            errores.add("Hubo un error");
        }



        
        return new FormacionDTOSalida(FormacionMapper.convertiraDTO(formacion), new Timestamp(System.currentTimeMillis()) , errores);


    }

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


            return new ListaUsuarioDTOSalida(usuarios, new Timestamp(System.currentTimeMillis()), errores);


        }catch (Exception e){
            errores.add("Hubo un error");
        }


        return new ListaUsuarioDTOSalida(usuarios, new Timestamp(System.currentTimeMillis()), errores);
    }


}
