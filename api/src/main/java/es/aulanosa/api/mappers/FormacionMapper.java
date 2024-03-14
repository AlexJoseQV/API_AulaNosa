package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.FormacionDTO;
import es.aulanosa.api.models.Formacion;

public class FormacionMapper {

    FormacionDTO formacionADTO(Formacion formacion) {
        return new FormacionDTO(formacion.getId(), formacion.getTitulo(), formacion.getDescripcion(), formacion.getRequisitos(), formacion.getInicio(), formacion.getFin(), formacion.getFecha(), formacion.getCoste(), formacion.getEstado(), formacion.getImagen());
    };
    Formacion dtoToFormacion(FormacionDTO formacionDTO) {
        return new Formacion();
    };
}
