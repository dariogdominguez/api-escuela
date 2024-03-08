package ar.com.dario.colmena.api.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import ar.com.dario.colmena.api.entities.Base;
import ar.com.dario.colmena.api.repository.BaseRepository;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Override
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E findById(ID id) throws Exception {
        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID debe ser un Long.");
            }
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E save(E entity) throws Exception {
        try {
            if (entity == null) {
                throw new IllegalArgumentException("El entity debe ser un Objeto Person y no puede ser nulo.");
            }
            return baseRepository.save(entity); 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID debe ser un Long y no puede ser nulo.");
            }
            Optional<E> entityOptional = baseRepository.findById(id);
            
            if (entityOptional.isPresent() && entity != null) {
                return  baseRepository.save(entity);
            } else {
                throw new Exception("No se encontró una persona con el ID proporcionado: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar la persona: " + e.getMessage());
        }
    }


        @Override
        public boolean delete(ID id) throws Exception {
            try {
                if (id == null) {
                    throw new IllegalArgumentException("El ID debe ser un Long y no puede ser nulo.");
                }
                if (baseRepository.existsById(id)) {
                    baseRepository.deleteById(id);
                    return true;
                }else{
                    throw new Exception("No se encontro ningun usuario con el id=${id}");
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        /*@Override
        public E findByName(String name) throws Exception{
            try {
                if (name != null) {
                    baseRepository.findOne(null);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }*/

}