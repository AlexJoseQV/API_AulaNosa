package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.FormacionDTO;
import es.aulanosa.api.models.Formacion;

import java.util.ArrayList;
import java.util.List;

/**
 * clase con los metodos de mapeo de un Formacion
 */
public class FormacionMapper {

    public static Formacion convertirAModel(FormacionDTO formacionDTO){

        String requisitos= "";
        for (String s : formacionDTO.getRequisitos() ) {
            requisitos+=s+"$$";
        }

        return  new Formacion(formacionDTO.getId(), formacionDTO.getTitulo(), formacionDTO.getDescripcion(), requisitos, formacionDTO.getInicio(), formacionDTO.getFin(), formacionDTO.getFecha() , formacionDTO.getCoste() , formacionDTO.getEstado() , formacionDTO.getImagen());
    }

    public static FormacionDTO convertiraDTO (Formacion formacion){


       List<String> requisitos = List.of(formacion.getRequisitos().split("\\$\\$"));

       return new FormacionDTO(formacion.getId(), formacion.getTitulo(), formacion.getDescripcion(), requisitos, formacion.getInicio() , formacion.getFin() , formacion.getCoste() , formacion.getEstado() , formacion.getImagen() , formacion.getFecha());
    }


    public static List<FormacionDTO> convertiraLista(List<Formacion> formaciones){

        List<FormacionDTO> formacionDTOS = new ArrayList<>();

        for ( Formacion f : formaciones
             ) {
            formacionDTOS.add(convertiraDTO(f));
        }

        return formacionDTOS;
    }
}
