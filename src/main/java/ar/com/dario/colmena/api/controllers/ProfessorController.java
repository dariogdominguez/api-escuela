package ar.com.dario.colmena.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.dario.colmena.api.entities.Professor;
import ar.com.dario.colmena.api.services.ProfessorServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/professor")
public class ProfessorController extends BaseControllerImpl<Professor, ProfessorServiceImpl> {

    private Long parseId(String id) throws IllegalArgumentException {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El ID debe ser un número entero válido.");
        }
    }
    
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        try {
            Long parsedId = parseId(id);
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(parsedId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. No se encontraron resultados\"}");
        }
    }
}
