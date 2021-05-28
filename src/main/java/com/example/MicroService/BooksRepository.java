package com.example.MicroService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books,Integer> {

    Books findById(int id);

//    @Query(value = "select b from Books b where b.getId()=?1")
//    Books findByBookId(int id);

    @Query(value = "select b from Books b")
    List<Books> getAllBooks();

//    @Query(value = "select b from Books b where b.getAuthors().getAuthorId() = ?1")
//    List<Books> findByAuthorId(int authorId);



}
