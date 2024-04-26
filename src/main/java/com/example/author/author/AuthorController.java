package com.example.author.author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/{email}")
    public ResponseEntity<?> findByEmail(
            @PathVariable String email
    ) {
        ;
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody AuthorRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{email}")
    public  ResponseEntity<?> delete(
            @PathVariable String email
    ) {
        service.delete(email);
        return ResponseEntity.ok().build();
    }


}
