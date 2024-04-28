package com.prefinals.prefinalsapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prefinals.prefinalsapi.Models.ReplyModel;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyModel, Integer>{
}
