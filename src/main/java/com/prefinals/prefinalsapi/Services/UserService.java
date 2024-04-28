package com.prefinals.prefinalsapi.Services;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prefinals.prefinalsapi.Models.UserModel;
import com.prefinals.prefinalsapi.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<UserModel> GetAll()
    {
        return userRepository.findAll();
    }

    public UserModel GetById(int id)
    {
        return userRepository.findById(id).orElseThrow();
    }

    public UserModel Create(UserModel user)
    {
        if(user != null)
        {
            List<UserModel> users = userRepository.findAll();

            Optional<UserModel> existingUser = users.stream()
                                                .filter(existing -> existing.getFirstName().equals(user.getFirstName())
                                                && existing.getLastName().equals(user.getLastName()))
                                                .findFirst();
            if(!existingUser.isPresent())
                return userRepository.save(user);
        }

        return null;
    }

    public UserModel Login(String firstname, String lastname)
    {
        if(firstname != null && lastname != null)
        {
            List<UserModel> users = GetAll();

            Optional<UserModel> existingUser = users.stream()
                                                .filter(existing -> existing.getFirstName().equals(firstname)
                                                && existing.getLastName().equals(lastname))
                                                .findFirst();

            return existingUser.orElse(null);
        }
        return null;
    }
}
