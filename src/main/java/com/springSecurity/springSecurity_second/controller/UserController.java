package com.springSecurity.springSecurity_second.controller;

import com.springSecurity.springSecurity_second.Exceptions.UserExistException;
import com.springSecurity.springSecurity_second.models.Users;
import com.springSecurity.springSecurity_second.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/fastApi/v1/all")

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<Users> findAllUsers(){

        return  userService.findAllUsers();
    }
////    GET USER BY NAME
//    @GetMapping("/{name}")
//    public Optional<Users> findBYUsername(@PathVariable String name){
//
//        return userService.findUserByName( name);
//    }


//    save new user
    @PostMapping("/newUser")
    public ResponseEntity<?> saveUser (@RequestBody Users users){

    try    {
      String message=   userService.saveUser(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }catch (UserExistException ex){


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user already exist try to log in");
    }


    }
}
