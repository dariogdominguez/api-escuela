package ar.com.dario.colmena.api.repository;

import org.springframework.stereotype.Repository;

import ar.com.dario.colmena.api.entities.Grade;

@Repository
public interface GardeRepository extends BaseRepository<Grade, Long> {
    
}
