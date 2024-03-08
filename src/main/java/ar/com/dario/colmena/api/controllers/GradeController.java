package ar.com.dario.colmena.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import ar.com.dario.colmena.api.entities.Grade;
import ar.com.dario.colmena.api.entities.Professor;
import ar.com.dario.colmena.api.entities.Student;
import ar.com.dario.colmena.api.services.GradeServiceImpl;
import ar.com.dario.colmena.api.services.ProfessorServiceImpl;
import ar.com.dario.colmena.api.services.StudentServiceImpl;

import java.util.HashSet;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/grade")
public class GradeController extends BaseControllerImpl<Grade, GradeServiceImpl> {

    @Autowired
    ProfessorServiceImpl professorService;
    @Autowired
    GradeServiceImpl gradeService;
    @Autowired
    StudentServiceImpl studentService;

    private static final Logger logger = Logger.getLogger(GradeController.class.getName());

    private Long parseId(String id) throws IllegalArgumentException {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El ID debe ser un número entero válido.");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveGradeWithOtherEntities(
            @RequestParam(value = "professorId", required = false) String professorId,
            @RequestParam(value = "studentId", required = false) String studentId,
            @RequestBody Grade grade) {
        try {
            if (professorId != null) {
                Long parsedId = parseId(professorId);
                Professor professor = professorService.findById(parsedId);
                if (professor != null) {
                    HashSet<Professor> professors = (HashSet<Professor>) grade.getProfessors();
                    professors.add(professor);
                    grade.setProfessors(professors);
                } else {
                    throw new Exception("No se encontró un profesor con el ID proporcionado: " + professorId);
                }
            }

            if (studentId != null) {
                Long parsedId = parseId(studentId);
                Student student = studentService.findById(parsedId);
                if (student != null) {
                    HashSet<Student> students = (HashSet<Student>) grade.getStudents();
                    students.add(student);
                    grade.setStudents(students);
                } else {
                    throw new Exception("No se encontró un estudiante con el ID proporcionado: " + studentId);
                }
            }

            // Guarda la entidad Grade
            Grade savedGrade = gradeService.save(grade);

            return ResponseEntity.ok(savedGrade);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{gradeId}/addProfessor")
    public ResponseEntity<String> addProfessorToGrade(@PathVariable Long gradeId, @RequestBody Professor professor) throws Exception {
        gradeService.addProfessorToGrade(gradeId, professor);
        return ResponseEntity.ok("Professor added to grade successfully.");
    }

    @PostMapping("/{gradeId}/addStudent")
    public ResponseEntity<String> addStudentToGrade(@PathVariable Long gradeId, @RequestBody Student student) throws Exception {
        gradeService.addStudentToGrade(gradeId, student);
        return ResponseEntity.ok("Student added to grade successfully.");
    }

}
