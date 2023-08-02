package com.example.KOISONN_MANES_MANA_AL_M2.Controllers;

import com.example.KOISONN_MANES_MANA_AL_M2.entities.Post;
import com.example.KOISONN_MANES_MANA_AL_M2.serviceinterface.PosteInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PosteInterface posteInterface;

    // Endpoint pour sauvegarder un nouveau post
    @PostMapping
    public ResponseEntity<Object> sauvegarderPost(@RequestBody Post post) {
        try {
            Post savedPost = posteInterface.sauvegarderPost(post);
            return ResponseEntity.ok(savedPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save post: " + e.getMessage());
        }
    }

    // Endpoint pour récupérer tous les posts
    @GetMapping
    public ResponseEntity<Object> obtenirTousLesPosts() {
        try {
            List<Post> posts = posteInterface.obtenirTousLesPosts();
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get all posts: " + e.getMessage());
        }
    }

    // Endpoint pour récupérer un post par ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenirPostParId(@PathVariable String id) {
        try {
            Post post = posteInterface.obtenirPostParId(id);
            if (post != null) {
                return ResponseEntity.ok(post);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get post by ID: " + e.getMessage());
        }
    }

    // Endpoint pour mettre à jour un post
    @PutMapping("/{id}")
    public ResponseEntity<Object> mettreAJourPost(@PathVariable String id, @RequestBody Post post) {
        try {
            post.setId(id);
            Post updatedPost = posteInterface.mettreAJourPost(post);
            if (updatedPost != null) {
                return ResponseEntity.ok(updatedPost);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update post: " + e.getMessage());
        }
    }

    // Endpoint pour supprimer un post par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> supprimerPostParId(@PathVariable String id) {
        try {
            posteInterface.supprimerPostParId(id);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete post: " + e.getMessage());
        }
    }
}
