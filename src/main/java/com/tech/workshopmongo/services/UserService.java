package com.tech.workshopmongo.services;

import com.tech.workshopmongo.domain.entities.User;
import com.tech.workshopmongo.repositories.UserRepository;
import com.tech.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
