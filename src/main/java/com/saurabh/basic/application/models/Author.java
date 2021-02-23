package com.saurabh.basic.application.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("author")
public class Author{

    @Id
    private String id;
    private String name;
    private int age;
    private String nationality;
    private List<Manga> manga;

    public Author(String id, String name, int age, String nationality, List<Manga> manga) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.manga = manga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Manga> getManga() {
        return manga;
    }

    public void setManga(List<Manga> manga) {
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", manga=" + manga +
                '}';
    }
}
