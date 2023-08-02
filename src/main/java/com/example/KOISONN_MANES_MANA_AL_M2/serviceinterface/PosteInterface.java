package com.example.KOISONN_MANES_MANA_AL_M2.serviceinterface;

import com.example.KOISONN_MANES_MANA_AL_M2.entities.Post;

import java.util.List;

public interface PosteInterface {

    Post sauvegarderPost(Post post);

    List<Post> obtenirTousLesPosts();

    Post obtenirPostParId(String id);

    Post mettreAJourPost(Post post);

    void supprimerPostParId(String id);
}
