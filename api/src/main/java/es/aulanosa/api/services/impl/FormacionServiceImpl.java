package es.aulanosa.api.services.impl;

import es.aulanosa.api.dtos.ListaEtiquetaDTOSalida;
import es.aulanosa.api.dtos.ListaFormacionDTOSailda;
import es.aulanosa.api.mappers.EtiquetaMapper;
import es.aulanosa.api.mappers.FormacionMapper;
import es.aulanosa.api.models.Formacion;
import es.aulanosa.api.repositories.FormacionRepository;
import es.aulanosa.api.services.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    private FormacionRepository formacionRepository;
    @Override
    public ListaFormacionDTOSailda listarFormaciones() {

        List<String> errores = new ArrayList<>();
        List<Formacion> formaciones = new ArrayList<>();
        try {

            formaciones = formacionRepository.findAll();

            return new ListaFormacionDTOSailda(FormacionMapper.convertiraLista(formaciones), new Timestamp(System.currentTimeMillis()) , errores);


        }catch (Exception e){
            errores.add("Hubo un error");
        }



        return new ListaFormacionDTOSailda(FormacionMapper.convertiraLista(formaciones), new Timestamp(System.currentTimeMillis()) , errores);
    }


}
