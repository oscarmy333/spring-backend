package org.unsch.springbackend.infrastructure.persistence.entities;

import jakarta.persistence.*;
import org.unsch.springbackend.domain.entities.Personal;

/**
 * Entidad JPA para persistencia - Mapea la tabla personal en la base de datos
 * Esta clase es la implementación concreta del acceso a datos
 */
@Entity
@Table(name = "personal")
public class PersonalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String correo;

    public PersonalEntity() {
    }

    // Constructor desde la entidad del dominio
    public PersonalEntity(Personal personal) {
        this.id = personal.getId();
        this.nombre = personal.getNombre();
        this.apellido = personal.getApellido();
        this.correo = personal.getCorreo();
    }

    // Convertir a entidad del dominio
    public Personal toDomain() {
        return new Personal(this.id, this.nombre, this.apellido, this.correo);
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

