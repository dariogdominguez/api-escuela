package ar.com.dario.colmena.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.dario.colmena.api.entities.Professor;
import ar.com.dario.colmena.api.repository.BaseRepository;
import ar.com.dario.colmena.api.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorServiceImpl extends BaseServiceImpl<Professor, Long> implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public ProfessorServiceImpl(BaseRepository<Professor, Long> baseRepository) {
        super(baseRepository);
    }
}
