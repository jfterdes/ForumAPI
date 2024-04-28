package com.prefinals.prefinalsapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prefinals.prefinalsapi.Models.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer>{
}
