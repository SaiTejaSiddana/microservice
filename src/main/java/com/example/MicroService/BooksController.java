package com.example.MicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    AuthorsRepository authorsRepository;


    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return booksRepository.getAllBooks();
    }

//    @GetMapping("/books/{authorId}")
//    public List<Books> getBooksByAuthorId(@PathVariable int authorId){
//        return booksRepository.findByAuthorId(authorId);
//    }
//
    @PostMapping("/books/{authorId}")
    public Books addBook(@PathVariable int authorId, @Valid @RequestBody Books book){
        Optional<Authors> authors = authorsRepository.findById(authorId);
        return authorsRepository.findById(authorId).map(author -> {
            book.setAuthors(author);
            return booksRepository.save(book);
        }).orElseThrow(()->new ResourceNotFoundException("Author not found with Id " + authorId));
    }

    @GetMapping("/book/{bookId}")
    public Books getBooks(@PathVariable("bookId") int bookId){
        if(booksRepository.existsById(bookId))
            return booksRepository.findById(bookId);
        else throw new ResourceNotFoundException("Data not found on server");
    }


//    @PutMapping("/authors/{authorId}/books/{bookId}")
//    public Books updateBook(@PathVariable int authorId,
//                               @PathVariable int bookId,
//                               @Valid @RequestBody Books bookRequest) {
//        if(!authorsRepository.existsById(authorId)) {
//            throw new ResourceNotFoundException("Author not found with id " + authorId);
//        }
//
//        return booksRepository.findById(bookId)
//                .map(book -> {
//                    book.setBookName(bookRequest.getBookName());
//                    return booksRepository.save(book);
//                }).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + bookId));
//    }

}
