package org.unsch.springbackend.infrastructure.persistence.repositories;

import org.springframework.stereotype.Repository;
import org.unsch.springbackend.domain.entities.Personal;
import org.unsch.springbackend.domain.repositories.IPersonalRepository;
import org.unsch.springbackend.infrastructure.persistence.entities.PersonalEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación del repositorio - Adapter que conecta el dominio con JPA
 * Implementa la interfaz del dominio usando Spring Data JPA
 */
@Repository
public class PersonalRepositoryImpl implements IPersonalRepository {

    private final SpringDataPersonalRepository springDataRepository;

    public PersonalRepositoryImpl(SpringDataPersonalRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Personal save(Personal personal) {
        PersonalEntity entity = new PersonalEntity(personal);
        PersonalEntity savedEntity = springDataRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public List<Personal> findAll() {
        List<PersonalEntity> entities = springDataRepository.findAll();
        return entities.stream()
                .map(PersonalEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Personal> findById(Long id) {
        return springDataRepository.findById(id)
                .map(PersonalEntity::toDomain);
    }

    @Override
    public Personal update(Personal personal) {
        PersonalEntity entity = new PersonalEntity(personal);
        PersonalEntity updatedEntity = springDataRepository.save(entity);
        return updatedEntity.toDomain();
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataRepository.existsById(id);
    }
}

