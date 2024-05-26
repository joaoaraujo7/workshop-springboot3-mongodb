package com.tech.workshopmongo.services;

import com.tech.workshopmongo.domain.Post;
import com.tech.workshopmongo.repositories.PostRepository;
import com.tech.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
        maxDate = maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
