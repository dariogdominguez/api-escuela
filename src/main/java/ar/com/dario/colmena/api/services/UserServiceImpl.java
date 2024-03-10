package ar.com.dario.colmena.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.dario.colmena.api.entities.User;
import ar.com.dario.colmena.api.repository.BaseRepository;
import ar.com.dario.colmena.api.repository.UserRepository;

public class UserServiceImpl extends BaseServiceImpl <User, Long> implements UserService{

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(BaseRepository <User, Long> baseRepository) {
        super(baseRepository);
    }
    
}
