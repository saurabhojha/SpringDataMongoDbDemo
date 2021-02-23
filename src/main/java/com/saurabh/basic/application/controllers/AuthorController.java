package com.saurabh.basic.application.controllers;

import com.saurabh.basic.application.models.Author;
import com.saurabh.basic.application.models.Manga;
import com.saurabh.basic.application.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(@Autowired AuthorService authorService) {
        this.authorService = authorService;
    }

    //Get requests
    @GetMapping
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/byId/{id}")
    public Optional<Author> getAuthorById(@PathVariable("id") String id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/byNationality/{nation}")
    public  List<Author> getAuthorByNation(@PathVariable("nation") String nation) {
        return authorService.getAuthorByNation(nation);
    }

    @GetMapping("/mangaByAuthor/{id}")
    public List<Manga> getMangaByAuthor(@PathVariable("id") String id) {
        return authorService.getMangaByAuthor(id);
    }

    //Post requests
    @PostMapping
    public List<Author> addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PostMapping("/addMangaById/{id}")
    public Optional<Author> addMangaById(@PathVariable String id, @RequestBody Manga manga) {
        return authorService.addMangaById(id,manga);
    }

    //Put requests
    @PutMapping("/updateAge/{id}")
    public Optional<Author> updateAge(@PathVariable String id, @RequestBody Map<String,Object> payload) {

        return authorService.updateAge(id, (int) ((Map<?, ?>) payload).get("age"));
    }

    //Delete Requests
    @DeleteMapping("/deleteAuthor/{id}")
    public List<Author> deleteAuthor(@PathVariable String id) {
        return authorService.deleteAuthor(id);
    }
}
