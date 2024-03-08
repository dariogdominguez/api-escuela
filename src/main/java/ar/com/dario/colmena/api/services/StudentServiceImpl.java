package ar.com.dario.colmena.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.dario.colmena.api.entities.Student;
import ar.com.dario.colmena.api.repository.BaseRepository;
import ar.com.dario.colmena.api.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<Student, Long> implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentServiceImpl(BaseRepository<Student, Long> baseRepository) {
        super(baseRepository);
    }

}
