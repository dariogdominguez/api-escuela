package ar.com.dario.colmena.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.dario.colmena.api.entities.Grade;
import ar.com.dario.colmena.api.entities.Professor;
import ar.com.dario.colmena.api.entities.Student;
import ar.com.dario.colmena.api.repository.BaseRepository;
import ar.com.dario.colmena.api.repository.GardeRepository;

@Service
@Transactional
public class GradeServiceImpl extends BaseServiceImpl<Grade, Long> implements GradeService {

    @Autowired
    GardeRepository gardeRepository;

    public GradeServiceImpl(BaseRepository<Grade, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public void addProfessorToGrade(Long gradeId, Professor professor) throws Exception {
        try {
            if (gradeId != null) {
                Grade grade = gardeRepository.findById(gradeId).orElse(null);
            if (grade != null) {
                grade.addProfessor(professor);
                gardeRepository.save(grade);
            }else{
                throw new Exception("No se encontro un grado con ese ID: " + gradeId);
            }
            }else{
                throw new Exception("El ID proporcionado debe ser numerico y no nulo: " + gradeId);
            }
            
        } catch (Exception e) {
            throw new Exception("No se pudo agregar el nuevo professor: " + e.getMessage());
        }
    }

    @Transactional
    public void addStudentToGrade(Long gradeId, Student student) throws Exception {
        try {
            if (gradeId != null) {
                Grade grade = gardeRepository.findById(gradeId).orElse(null);
            if (grade != null) {
                grade.addStudent(student);
                gardeRepository.save(grade);
            }else{
                throw new Exception("No se encontro un grado con ese ID: " + gradeId);
            }
            }else{
                throw new Exception("El ID proporcionado debe ser numerico y no nulo: " + gradeId);
            }
            
        } catch (Exception e) {
            throw new Exception("No se pudo agregar el nuevo estudiante: " + e.getMessage());
        }
    }

}
