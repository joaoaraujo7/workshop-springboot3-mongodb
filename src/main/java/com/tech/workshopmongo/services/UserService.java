package com.tech.workshopmongo.services;

import com.tech.workshopmongo.domain.User;
import com.tech.workshopmongo.dto.UserDTO;
import com.tech.workshopmongo.repositories.UserRepository;
import com.tech.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void deleteUserById(String id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public void update(String id, User user) {
        User newUser = findById(id);
        updateData(newUser, user);
        userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
