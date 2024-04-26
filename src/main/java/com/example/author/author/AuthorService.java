package com.example.author.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public void save(AuthorRequest request) {
        var author = Author.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .build();
        repository.save(author);
    }

    public List<Author> findAll() {
        return repository.findAll();
    }

    public Author findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Author update(String email, AuthorRequest request){
        Author author = repository.findByEmail(email);;
        if(author == null){
            throw new RuntimeException("Author with email " + email + " not found.");
        }
        else{
            author.setFirstname(request.getFirstname());
            author.setLastname(request.getLastname());
            author.setEmail(request.getEmail());
            return repository.save(author);
        }
    }
    public void delete(String email){
        Author author = repository.findByEmail(email);
        if(author == null){
            return ;
        }
        repository.delete(author);
    }



}
