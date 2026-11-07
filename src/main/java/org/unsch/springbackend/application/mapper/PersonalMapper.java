package org.unsch.springbackend.application.mapper;

import org.unsch.springbackend.application.dto.PersonalDTO;
import org.unsch.springbackend.domain.entities.Personal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre entidades del dominio y DTOs
 */
public class PersonalMapper {

    /**
     * Convierte una entidad Personal a PersonalDTO
     */
    public static PersonalDTO toDTO(Personal personal) {
        if (personal == null) {
            return null;
        }
        return new PersonalDTO(
            personal.getId(),
            personal.getNombre(),
            personal.getApellido(),
            personal.getCorreo()
        );
    }

    /**
     * Convierte un PersonalDTO a entidad Personal
     */
    public static Personal toEntity(PersonalDTO dto) {
        if (dto == null) {
            return null;
        }
        Personal personal = new Personal();
        personal.setId(dto.getId());
        personal.setNombre(dto.getNombre());
        personal.setApellido(dto.getApellido());
        personal.setCorreo(dto.getCorreo());
        return personal;
    }

    /**
     * Convierte una lista de Personal a lista de PersonalDTO
     */
    public static List<PersonalDTO> toDTOList(List<Personal> personalList) {
        if (personalList == null) {
            return null;
        }
        return personalList.stream()
                .map(PersonalMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de PersonalDTO a lista de Personal
     */
    public static List<Personal> toEntityList(List<PersonalDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream()
                .map(PersonalMapper::toEntity)
                .collect(Collectors.toList());
    }
}

