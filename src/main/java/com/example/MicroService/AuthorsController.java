package com.example.MicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorsController {
    @Autowired
    AuthorsRepository authorsRepository;

    @GetMapping("/authors")
    public List<Authors> getAllAuthors(){
        return authorsRepository.getAllAuthors();
    }

    @PostMapping("/authors")
    public Authors createAuthor(@Valid @RequestBody Authors author){
        return authorsRepository.save(author);
    }

    @PutMapping("/authors/{authorId}")
    public Authors updateAuthor(@PathVariable int authorId,
                                   @Valid @RequestBody Authors authorRequest) {
        return authorsRepository.findById(authorId)
                .map(author -> {
                    author.setAuthorName(authorRequest.getAuthorName());
                    return authorsRepository.save(author);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + authorId));
    }


}
