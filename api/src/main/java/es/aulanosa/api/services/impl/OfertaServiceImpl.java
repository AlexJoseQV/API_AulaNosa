package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.*;
import es.aulanosa.api.mappers.OfertaMapper;
import es.aulanosa.api.mappers.UsuarioMapper;
import es.aulanosa.api.models.*;
import es.aulanosa.api.repositories.*;
import es.aulanosa.api.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase empleada para establecer la comunicación y lógica entre los controladores de las Ofertas con la base de datos
 * @author ALEXJOSE
 */
@Service
public class OfertaServiceImpl implements OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository; // Instancia de la clase repositorio de oferta

    @Autowired
    private UsuarioRepository usuarioRepository; // Instancia de la clase repositorio del usuario

    @Autowired
    private UsuarioEtiquetaRepository usuarioEtiquetaRepository;

    @Autowired
    private OfertaEtiquetaRepository ofertaEtiquetaRepository;


    @Autowired
    private UsuarioOfertaRepository usuarioOfertaRepository;

    /**
     * Método empleado para obtener todas las ofertas disponibles que se encuentran en estado 'ABIERTA' ordenados por fecha más reciente
     * @return Listado con la información de las ofertas
     */
    @Override
    public ListaOfertaDTOSalida listarOfertas(){
        List<String> errores = new ArrayList<>();
        List<OfertaDTO> ofertasDTO = new ArrayList<>();

        try {
            ofertasDTO = OfertaMapper.convertirListaADTO(ofertaRepository.findByEstadoOrderByFechaDesc("ABIERTA")); // Se obtiene el listado con toda la información de las ofertas

        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new ListaOfertaDTOSalida(errores, new Timestamp(System.currentTimeMillis()), ofertasDTO);
    }

    /**
     * Método empleado para obtener la información de una oferta en base a indicarle el identificador de la oferta
     * @param idOferta Identificador de la oferta
     * @return Se devuelve la información de la oferta indicada
     */
    @Override
    public OfertaDTOSalida devolverOferta(int idOferta){
        List<String> errores = new ArrayList<>();
        OfertaDTO ofertaDTO = null;
        try {
            // Obtener el usuario por id
            Optional<Oferta> ofertaOpt = ofertaRepository.findById(idOferta);

            if(ofertaOpt.isPresent()){ // Se comprueba que exista
                ofertaDTO = OfertaMapper.convertirADTO(ofertaOpt.get()); // Se obtiene la información de la oferta
            }else{
                errores.add("Error la oferta no existe");
            }

        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new OfertaDTOSalida(errores, new Timestamp(System.currentTimeMillis()), ofertaDTO != null ? ofertaDTO : new OfertaDTO());
    }

    /**
     * Método empleado para obtener un listado con la información de los usuarios que se encuentran inscritos en una oferta indicada
     * @param idOferta Identificador de la oferta
     * @return Se devuelve un listado con la información de los usuarios inscritos en la oferta indicada
     */
    @Override
    public ListaUsuarioDTOSalida listarUsuariosOferta(int idOferta){
        List<String> errores = new ArrayList<>();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        try {
            // Buscar todas las inscripciones de la oferta
            List<UsuarioOferta> inscripciones = usuarioOfertaRepository.findAllByOfertaId(idOferta);

            // Para cada inscripción, obtener el usuario y convertirlo a DTO
            for (UsuarioOferta inscripcion : inscripciones) {
                Optional<Usuario> usuarioOpt = usuarioRepository.findById(inscripcion.getUsuarioId());
                usuarioOpt.ifPresent(usuario -> usuariosDTO.add(UsuarioMapper.convertirADTO(usuario)));
            }
        } catch (Exception e) {
            errores.add("Error con la base de datos");
        }

        return new ListaUsuarioDTOSalida(errores, new Timestamp(System.currentTimeMillis()), usuariosDTO);
    }

    /**
     * Este método permite crear una oferta
     * @param ofertaDTO objeto de la clase OfertaDTO
     * @return objeto de la clase OfertaDTOSalida
     */
    @Override
    public OfertaDTOSalida crearOferta(OfertaDTO ofertaDTO) {
        List<String> errores = new ArrayList<>();
        Oferta oferta = null;
        ofertaDTO.setFecha(new Timestamp(System.currentTimeMillis()));
        try{
            oferta = ofertaRepository.save(OfertaMapper.convertirAModel(ofertaDTO));
        }catch (Exception e) {
            errores.add("Error con la base de datos");

        }
        return new OfertaDTOSalida(errores,new Timestamp(System.currentTimeMillis()), oferta != null ? OfertaMapper.convertirADTO(oferta) : new OfertaDTO());
    }

    /**
     * Este método permite inscribir un usuario en una oferta
     * @param idUsuario objeto de la clase usuarioDTO
     * @param idOferta identificador de una oferta
     * @param estado estado de la oferta
     * @return Objeto de la clase GenericoDTOSalida con la información general
     */
    @Override
    public GenericoDTOSalida insribirUsuario(int idUsuario, int idOferta, String estado) {
        List<String> errores = new ArrayList<>();
        try {
            usuarioOfertaRepository.insertar(idUsuario, idOferta, estado);
        } catch (Exception e) {
            errores.add("Hubo un error");

        }
        return new GenericoDTOSalida(errores, new Timestamp(System.currentTimeMillis()));
    }

    /**
     * Este método permite eliminar la relación correspondiente de un usuario con una oferta
     * @param idUsuario Identificador del usuario
     * @param idOferta Identificador de la oferta
     * @return Se devuelve un indicador que muestra el estado correspondiente de la operación
     */
    @Override
    public GenericoDTOSalida eliminarOfertaDeUsuario(int idUsuario, int idOferta){
        List<String> errores = new ArrayList<>();
        try {
            // Se intenta obtener la instancia
            Optional<UsuarioOferta> usuarioOfertaOpcional = usuarioOfertaRepository.findByUsuarioIdAndOfertaId(idUsuario, idOferta);

            if (usuarioOfertaOpcional.isPresent()) {
                // La instancia existe, entonces eliminarla
                UsuarioOferta usuarioOferta = usuarioOfertaOpcional.get();
                usuarioOfertaRepository.delete(usuarioOferta);
            }else{
                errores.add("Error no existe la oferta indicada para ese usuario");
            }
        }catch (Exception e){
            errores.add("Error con la base de datos");
        }

        return new GenericoDTOSalida(errores, new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public ListaOfertaUsuarioDTOSalida listarOfertaUsuario(int idUsuario) {

        List<String> errores = new ArrayList<>();
        List<Oferta> ofertas = new ArrayList<>();
        List<OfertaUsuarioDTO> ofertasUsuarioDTO = new ArrayList<>();

        try {

            ofertas = ofertaRepository.findAll();

            for(Oferta o : ofertas) {

                UsuarioOferta usuarioOferta = usuarioOfertaRepository.consultarOferta(idUsuario, o.getId());
                OfertaUsuarioDTO ofertaUsuarioDTO = new OfertaUsuarioDTO();
                ofertaUsuarioDTO.setOferta(OfertaMapper.convertirADTO(o));
                ofertaUsuarioDTO.setInscrito(false);
                ofertaUsuarioDTO.setInteresado(false);

                if (ofertaUsuarioDTO != null) {
                    if (usuarioOferta.getEstado().equals("INSCRITO")) {
                        ofertaUsuarioDTO.setInscrito(true);
                    }

                    List<OfertaEtiqueta> ofertasEtiqueta = ofertaEtiquetaRepository.findAllByOfertaId(o.getId());
                    List<UsuarioEtiqueta> etiquetaUsuario = usuarioEtiquetaRepository.findAllByUsuarioId(idUsuario);

                    for (OfertaEtiqueta oe : ofertasEtiqueta) {
                        for(UsuarioEtiqueta ue : etiquetaUsuario) {
                            if (ue.getEtiquetaId() == oe.getEtiquetaId()) {
                                ofertaUsuarioDTO.setInteresado(true);
                                break;
                            }
                        }
                    }
                }

                ofertasUsuarioDTO.add(ofertaUsuarioDTO);
            }

            return new ListaOfertaUsuarioDTOSalida(ofertasUsuarioDTO,errores,new Timestamp(System.currentTimeMillis()));


        }catch(Exception ex) {
            errores.add("Error durante la ejecucion.");
        }

        return new ListaOfertaUsuarioDTOSalida(ofertasUsuarioDTO,errores,new Timestamp(System.currentTimeMillis()));
    }

}
