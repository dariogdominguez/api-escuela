package ar.com.dario.colmena.api.repository;

import org.springframework.stereotype.Repository;

import ar.com.dario.colmena.api.entities.Professor;

@Repository
public interface ProfessorRepository extends BaseRepository<Professor, Long> {
}
