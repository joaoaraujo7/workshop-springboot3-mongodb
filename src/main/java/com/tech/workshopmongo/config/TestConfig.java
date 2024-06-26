package com.tech.workshopmongo.config;

import com.tech.workshopmongo.domain.Post;
import com.tech.workshopmongo.domain.User;
import com.tech.workshopmongo.dto.AuthorDTO;
import com.tech.workshopmongo.dto.CommentDTO;
import com.tech.workshopmongo.repositories.PostRepository;
import com.tech.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", dtf), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", dtf), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("21/03/2018", dtf), new AuthorDTO(user1));
        CommentDTO comment2 = new CommentDTO("Aproveite!", LocalDate.parse("22/03/2018", dtf), new AuthorDTO(user2));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("23/03/2018", dtf), new AuthorDTO(user2));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);
    }
}
