package com.prefinals.prefinalsapi.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prefinals.prefinalsapi.Models.PostModel;
import com.prefinals.prefinalsapi.Repositories.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    private UserService userService;

    PostService(PostRepository postRepository, UserService userService)
    {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<PostModel> GetAll()
    {
        return postRepository.findAll();
    }

    public PostModel GetById(int id)
    {
        return postRepository.findById(id).orElseThrow();
    }

    public List<PostModel> GetByPage(int page)
    {
        List<PostModel> posts = GetAll().stream()
                                    .filter(post -> post.getPage() == page)
                                    .collect(Collectors.toList());
        return posts; 
    }

    public PostModel Create(PostModel post)
    {
        if(post != null)
        {
            int userId = post.getUserId();

            try {
                if(userService.GetById(userId)!=null)
                {
                    return postRepository.save(post);
                }
            } catch (NoSuchElementException e) {
                return null;
            }
        }
        return null;
    }

    public boolean Delete(int id)
    {
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
