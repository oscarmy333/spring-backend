package org.unsch.springbackend.application.usecases;

import org.springframework.stereotype.Component;
import org.unsch.springbackend.application.dto.PersonalDTO;
import org.unsch.springbackend.application.mapper.PersonalMapper;
import org.unsch.springbackend.application.ports.IPersonalService;
import org.unsch.springbackend.domain.entities.Personal;
import org.unsch.springbackend.domain.exceptions.ResourceNotFoundException;
import org.unsch.springbackend.domain.repositories.IPersonalRepository;

import java.util.List;

/**
 * Caso de uso - Implementación de la lógica de negocio para Personal
 * Esta clase orquesta las operaciones entre el dominio y la infraestructura
 */
@Component
public class PersonalUseCase implements IPersonalService {

    private final IPersonalRepository personalRepository;

    public PersonalUseCase(IPersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public PersonalDTO save(PersonalDTO personalDTO) {
        // Convertir DTO a entidad del dominio
        Personal personal = PersonalMapper.toEntity(personalDTO);
        
        // Persistir usando el repositorio del dominio
        Personal savedPersonal = personalRepository.save(personal);
        
        // Convertir entidad a DTO para retornar
        return PersonalMapper.toDTO(savedPersonal);
    }

    @Override
    public List<PersonalDTO> findAll() {
        List<Personal> personalList = personalRepository.findAll();
        return PersonalMapper.toDTOList(personalList);
    }

    @Override
    public PersonalDTO findById(Long id) {
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personal", "Id", id));
        return PersonalMapper.toDTO(personal);
    }

    @Override
    public PersonalDTO update(PersonalDTO personalDTO, Long id) {
        // Verificar que existe
        Personal existingPersonal = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personal", "Id", id));
        
        // Actualizar campos
        existingPersonal.setNombre(personalDTO.getNombre());
        existingPersonal.setApellido(personalDTO.getApellido());
        existingPersonal.setCorreo(personalDTO.getCorreo());
        
        // Persistir cambios
        Personal updatedPersonal = personalRepository.update(existingPersonal);
        
        return PersonalMapper.toDTO(updatedPersonal);
    }

    @Override
    public void delete(Long id) {
        // Verificar que existe antes de eliminar
        if (!personalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Personal", "Id", id);
        }
        personalRepository.deleteById(id);
    }
}

