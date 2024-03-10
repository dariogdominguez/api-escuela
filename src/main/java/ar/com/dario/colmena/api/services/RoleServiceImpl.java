package ar.com.dario.colmena.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.dario.colmena.api.entities.Role;
import ar.com.dario.colmena.api.repository.BaseRepository;
import ar.com.dario.colmena.api.repository.RoleRepository;

public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService{
    
    @Autowired
    RoleRepository roleRepository;

    public RoleServiceImpl(BaseRepository<Role, Long> baseRepository) {
        super(baseRepository);
    }
    
}
