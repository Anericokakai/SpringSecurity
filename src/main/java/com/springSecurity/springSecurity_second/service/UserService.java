package com.springSecurity.springSecurity_second.service;

import com.springSecurity.springSecurity_second.models.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<Users> findAllUsers();

//    Optional<Users> findUserByName (String name);

    String saveUser (Users users);
}
