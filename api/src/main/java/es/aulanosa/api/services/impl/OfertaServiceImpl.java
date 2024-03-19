package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.*;
import es.aulanosa.api.mappers.OfertaMapper;
import es.aulanosa.api.mappers.UsuarioMapper;
import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.models.Usuario;
import es.aulanosa.api.models.UsuarioOferta;
import es.aulanosa.api.repositories.OfertaRepository;
import es.aulanosa.api.repositories.UsuarioOfertaRepository;
import es.aulanosa.api.repositories.UsuarioRepository;
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
}
