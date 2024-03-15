package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.ListaOfertaDTOSalida;
import es.aulanosa.api.dtos.OfertaDTO;
import es.aulanosa.api.dtos.OfertaDTOSalida;
import es.aulanosa.api.mappers.OfertaMapper;
import es.aulanosa.api.models.Oferta;
import es.aulanosa.api.repositories.OfertaRepository;
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

    /**
     * Método empleado para obtener todas las ofertas disponibles
     * @return Listado con la información de las ofertas
     */
    @Override
    public ListaOfertaDTOSalida listarOfertas(){
        List<String> errores = new ArrayList<>();
        List<OfertaDTO> ofertasDTO = new ArrayList<>();

        try {
            ofertasDTO = OfertaMapper.convertirListaADTO(ofertaRepository.findAll()); // Se obtiene el listado con toda la información de las ofertas

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
}
