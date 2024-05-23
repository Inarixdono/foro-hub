package com.inarixdono.forohub.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUserById(Integer id) {
        return repository.getReferenceById(id);
    }
}
