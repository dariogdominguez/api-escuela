package ar.com.dario.colmena.api.repository;

import org.springframework.stereotype.Repository;

import ar.com.dario.colmena.api.entities.Student;

@Repository
public interface StudentRepository extends BaseRepository <Student, Long> {
}
