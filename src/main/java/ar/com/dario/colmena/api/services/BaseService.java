package ar.com.dario.colmena.api.services;

import java.io.Serializable;
import java.util.List;

import ar.com.dario.colmena.api.entities.Base;

public interface BaseService <E extends Base, ID extends Serializable> {
    List<E> findAll() throws Exception;
    E findById(ID id) throws Exception;
    E save(E entity) throws Exception;
    E update(ID id, E entity) throws Exception;
    boolean delete(ID id) throws Exception;
    //E findByName(String name) throws Exception;
}
