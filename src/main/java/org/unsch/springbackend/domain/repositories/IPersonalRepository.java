package org.unsch.springbackend.domain.repositories;

import org.unsch.springbackend.domain.entities.Personal;
import java.util.List;
import java.util.Optional;

/**
 * Puerto del repositorio - Interfaz que define las operaciones de acceso a datos
 * Esta es una abstracción que será implementada en la capa de infraestructura
 */
public interface IPersonalRepository {
    
    Personal save(Personal personal);
    
    List<Personal> findAll();
    
    Optional<Personal> findById(Long id);
    
    Personal update(Personal personal);
    
    void deleteById(Long id);
    
    boolean existsById(Long id);
}

