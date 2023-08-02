package com.example.KOISONN_MANES_MANA_AL_M2.service;

import com.example.KOISONN_MANES_MANA_AL_M2.entities.Post;
import com.example.KOISONN_MANES_MANA_AL_M2.serviceinterface.PosteInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class PostService implements PosteInterface {



    @Autowired
    private  MongoTemplate mongoTemplate;




    // Opérations CRUD

    // Create (Insert)
    public Post sauvegarderPost(Post post) {
        return mongoTemplate.save(post);
    }

    // Read (Find)
    public List<Post> obtenirTousLesPosts() {
        return mongoTemplate.findAll(Post.class);
    }

    public Post obtenirPostParId(String id) {
        return mongoTemplate.findById(id, Post.class);
    }

    // Update
    public Post mettreAJourPost(Post post) {
        return mongoTemplate.save(post);
    }

    // Delete
    public void supprimerPostParId(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), Post.class);
    }
}
