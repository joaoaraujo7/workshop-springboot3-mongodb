package com.tech.workshopmongo.config;

import com.tech.workshopmongo.domain.entities.User;
import com.tech.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user1 = new User("Maria Brown", "maria@gmail.com");
        User user2 = new User("Alex Green", "alex@gmail.com");
        User user3 = new User("Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
