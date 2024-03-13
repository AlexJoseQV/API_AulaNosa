package es.aulanosa.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Usuarios")
@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private Timestamp actualizacion;
    private enum Estado {
        EMPLEADO,
        DESEMPLEADO
    }

}
