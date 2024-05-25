package com.tech.workshopmongo.config;

import com.tech.workshopmongo.domain.Post;
import com.tech.workshopmongo.domain.User;
import com.tech.workshopmongo.repositories.PostRepository;
import com.tech.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User("Maria Brown", "maria@gmail.com");
        User user2 = new User("Alex Green", "alex@gmail.com");
        User user3 = new User("Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.parse("21/05/2024", dtf), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", user1);
        Post post2 = new Post(null, LocalDate.parse("04/02/2024", dtf), "Bom dia", "Acordei feliz hoje!", user1);


        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
