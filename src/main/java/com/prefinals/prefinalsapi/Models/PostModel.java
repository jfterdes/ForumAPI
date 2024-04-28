package com.prefinals.prefinalsapi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "page")
    private int page;
   
    @Column(name = "userId")
    private int userId;

    @Column(name = "post")
    private String post;

    public PostModel(int userId, String post)
    {
        this.userId = userId;
        this.post = post;
    }
}
