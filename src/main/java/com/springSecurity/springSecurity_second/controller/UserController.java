package com.springSecurity.springSecurity_second.controller;

import com.springSecurity.springSecurity_second.models.Users;
import com.springSecurity.springSecurity_second.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fastApi/v1")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Users> findAllUsers(){

        return  userService.findAllUsers();
    }
//    GET USER BY NAME
    @GetMapping("/{name}")
    public Optional<Users> findBYUsername(@PathVariable String name){

        return userService.findUserByName( name);
    }


//    save new user
    @PostMapping("/new")
    public String saveUser (@RequestBody Users users){
      return   userService.saveUser(users);

    }
}
