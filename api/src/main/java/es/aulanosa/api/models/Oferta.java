package es.aulanosa.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

    @Table(name = "Ofertas")
    @Entity
    public class Oferta {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id

        // Atributos
        private int id;
        private int vacantes;
        private String titulo;
        private String estado;
        private String descripcion;
        private String requisitos; // Mappear desde ArrayList<EtiquetasDTO>

        // Constructor
        public Oferta () {}

        // Getters y Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVacantes() {
            return vacantes;
        }

        public void setVacantes(int vacantes) {
            this.vacantes = vacantes;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getRequisitos() {
            return requisitos;
        }

        public void setRequisitos(String requisitos) {
            this.requisitos = requisitos;
        }

        // Metodos
        @Override
        public String toString() {
            return "Oferta{" +
                    "id=" + id +
                    ", vacantes=" + vacantes +
                    ", titulo='" + titulo + '\'' +
                    ", estado='" + estado + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", requisitos='" + requisitos + '\'' +
                    '}';
        }
    }
