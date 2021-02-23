package com.saurabh.basic.application.repositories;

import com.saurabh.basic.application.models.Author;
import com.saurabh.basic.application.models.Manga;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author,String>, CustomAuthorRepository {

    //Find authors by nationality.
    List<Author> findByNationality(String nation);
}
