package org.unsch.springbackend.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsch.springbackend.infrastructure.persistence.entities.PersonalEntity;

/**
 * Repositorio Spring Data JPA - Acceso directo a la base de datos
 */
@Repository
public interface SpringDataPersonalRepository extends JpaRepository<PersonalEntity, Long> {
    
}

