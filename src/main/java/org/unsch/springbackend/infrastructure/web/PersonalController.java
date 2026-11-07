package org.unsch.springbackend.infrastructure.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsch.springbackend.application.dto.PersonalDTO;
import org.unsch.springbackend.application.ports.IPersonalService;

import java.util.List;

/**
 * Controlador REST - Adapter que expone los endpoints HTTP
 * Este controlador actúa como un adaptador entre el mundo exterior y la aplicación
 */
@RestController
@RequestMapping(value = "api/personales")
public class PersonalController {

    private final IPersonalService personalService;

    public PersonalController(IPersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public List<PersonalDTO> getAllPersonal() {
        return personalService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonalDTO> getPersonalPorId(@PathVariable("id") Long id) {
        PersonalDTO personal = personalService.findById(id);
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonalDTO> savePersonal(@RequestBody PersonalDTO personal) {
        PersonalDTO savedPersonal = personalService.save(personal);
        return new ResponseEntity<>(savedPersonal, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonalDTO> updatePersonal(@PathVariable("id") Long id, 
                                                       @RequestBody PersonalDTO personal) {
        PersonalDTO updatedPersonal = personalService.update(personal, id);
        return new ResponseEntity<>(updatedPersonal, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePersonal(@PathVariable("id") Long id) {
        personalService.delete(id);
        return new ResponseEntity<>("Personal ha sido eliminado!", HttpStatus.OK);
    }
}

