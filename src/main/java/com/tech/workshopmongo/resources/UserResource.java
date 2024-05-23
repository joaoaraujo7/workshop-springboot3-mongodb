package com.tech.workshopmongo.resources;

import com.tech.workshopmongo.domain.entities.User;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User("1", "Maria Silva", "maria@gmail.com");
        User user2 = new User("2", "Fernando Oliveira", "fernado@gmail.com");
        List<User> users = Arrays.asList(user1, user2);
        return ResponseEntity.ok().body(users);
    }
}
