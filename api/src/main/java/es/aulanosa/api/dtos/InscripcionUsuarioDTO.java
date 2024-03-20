package es.aulanosa.api.dtos;

import jakarta.validation.constraints.NotNull;

/**
 * Clase DTO para manejar información correspondiente para la inscripción de un usuario en una formación
 */
public class InscripcionUsuarioDTO {
    @NotNull(message = "El usuarioId no puede ser nulo")
    private int usuarioId; // Identificador del usuario

    public InscripcionUsuarioDTO() {
    }

    public InscripcionUsuarioDTO(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "InscribirUsuarioDTO{" +
                "usuarioId=" + usuarioId +
                '}';
    }

}
