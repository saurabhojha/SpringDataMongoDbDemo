package com.saurabh.basic.application.services;

import com.saurabh.basic.application.models.Author;
import com.saurabh.basic.application.models.Manga;
import com.saurabh.basic.application.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(@Autowired AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> addAuthor(Author author) {
        authorRepository.save(author);
        return findAllAuthors();
    }

    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAuthorByNation(String nation) {
        return authorRepository.findByNationality(nation);
    }

    public Optional<Author> addMangaById(String id, Manga manga) {
        authorRepository.addManga(id,manga);
        return getAuthorById(id);
    }

    public Optional<Author> updateAge(String id,int age) {
        authorRepository.updateAge(id,age);
        return getAuthorById(id);
    }

    public List<Author> deleteAuthor(String id) {
        authorRepository.deleteById(id);
        return findAllAuthors();
    }

    public List<Manga> getMangaByAuthor(String id) {

       return authorRepository.getMangaByAuthor(id);

    }
}
