package com.prefinals.prefinalsapi.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prefinals.prefinalsapi.Models.PostModel;
import com.prefinals.prefinalsapi.Services.PostService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("api/post")
public class PostController {
    private PostService postService;

    PostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<PostModel>> GetAll() {
        List<PostModel> posts = postService.GetAll();
        if(!posts.isEmpty())
            return ResponseEntity.ok(posts);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PostModel> GetById(@PathVariable int id) {
        try {
            PostModel targetPost = postService.GetById(id);
            return ResponseEntity.ok(targetPost);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<List<PostModel>> GetByPage(@PathVariable int page) {
        try {
            List<PostModel> targetPosts = postService.GetByPage(page);
            return ResponseEntity.ok(targetPosts);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<PostModel> Create(@RequestBody PostModel post) {
        if(post != null)
        {
            PostModel newPost = postService.Create(post);
            if(newPost!=null)
                return ResponseEntity.ok(newPost);
        }
        
        return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable int id)
    {
        try {
            postService.Delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
