package com.prefinals.prefinalsapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prefinals.prefinalsapi.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
}
