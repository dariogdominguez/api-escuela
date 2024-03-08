package ar.com.dario.colmena.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ar.com.dario.colmena.api.entities.Student;
import ar.com.dario.colmena.api.services.StudentServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/student")
public class StudentController extends BaseControllerImpl<Student, StudentServiceImpl> {
}
