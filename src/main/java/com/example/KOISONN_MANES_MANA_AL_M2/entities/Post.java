package com.example.KOISONN_MANES_MANA_AL_M2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Post {

    @Id
    private String id;
    private String title;
    private String description;
    private String by;
    private String url;
    private List<String> tags;
    private int likes;
    private List<Comment> comments;
}
