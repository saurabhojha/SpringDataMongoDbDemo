package com.saurabh.basic.application.repositories;

import com.saurabh.basic.application.models.Author;
import com.saurabh.basic.application.models.Manga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomAuthorRepositoryImpl implements CustomAuthorRepository {

    private  final MongoTemplate mongoTemplate;

    public CustomAuthorRepositoryImpl(@Autowired MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public  Query getQuery(String id) {
        return new Query(Criteria.where("id").is(id));
    }

    @Override
    public void addManga(String id, Manga manga) {

        Query query = getQuery(id);
        Update update = new Update();
        update.addToSet("manga",manga);
        mongoTemplate.updateFirst(query,update,Author.class);
    }

    @Override
    public void updateAge(String id, int age) {
        Query query = getQuery(id);
        Update update = new Update();
        update.set("age",age);
        mongoTemplate.updateFirst(query,update,Author.class);
    }

    @Override
    public List<Manga> getMangaByAuthor(String id) {
        Query query = getQuery(id);
        query.fields().include("manga");
        return mongoTemplate.findOne(query,Author.class).getManga();

    }
}
