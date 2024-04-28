package com.prefinals.prefinalsapi.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prefinals.prefinalsapi.Models.UserModel;
import com.prefinals.prefinalsapi.Services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("api/user")
public class UserController {
    private UserService userService;

    UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserModel> Create(@RequestBody UserModel user) {
        if(user != null)
        {
            UserModel newUser = userService.Create(user);
            if(newUser!= null)
                return ResponseEntity.ok(newUser);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserModel> Login(@RequestBody UserModel user) {
        if(user != null)
        {
            try {
                if(userService.Login(user.getFirstName(), user.getLastName()) != null)
                    return ResponseEntity.ok(user);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }
    
}
