package com.example.KOISONN_MANES_MANA_AL_M2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@AllArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;
    private String user;
    private String message;
    private String likes;
    private Date dateCreate;
}
