package com.example.MicroService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorsRepository extends CrudRepository<Authors,Integer> {

//    Authors findByAuthorId(int id);

    @Query(value = "select a from Authors a")
    List<Authors> getAllAuthors();

}
