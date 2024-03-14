package es.aulanosa.api.mappers;

import es.aulanosa.api.dtos.FormacionDTO;
import es.aulanosa.api.models.Formacion;

public class FormacionMapper {

    FormacionDTO formacionADTO(Formacion formacion) {
        return new FormacionDTO();
    };
    Formacion dtoToFormacion(FormacionDTO formacionDTO) {
        return new Formacion();
    };
}
