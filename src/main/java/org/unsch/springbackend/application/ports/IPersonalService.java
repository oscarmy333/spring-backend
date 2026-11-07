package org.unsch.springbackend.application.ports;

import org.unsch.springbackend.application.dto.PersonalDTO;
import java.util.List;

/**
 * Puerto de entrada - Interfaz que define las operaciones del servicio
 * Esta interfaz es utilizada por los controladores (adaptadores)
 */
public interface IPersonalService {
    
    PersonalDTO save(PersonalDTO personalDTO);
    
    List<PersonalDTO> findAll();
    
    PersonalDTO findById(Long id);
    
    PersonalDTO update(PersonalDTO personalDTO, Long id);
    
    void delete(Long id);
}

