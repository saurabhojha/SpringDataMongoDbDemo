package com.saurabh.basic.application.repositories;

import com.saurabh.basic.application.models.Manga;

import java.util.List;

public interface CustomAuthorRepository {

    void addManga(String id, Manga manga);
    void updateAge(String id,int age);

    List<Manga> getMangaByAuthor(String id);
}
