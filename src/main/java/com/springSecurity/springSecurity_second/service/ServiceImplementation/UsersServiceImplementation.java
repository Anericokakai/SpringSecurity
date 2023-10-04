package com.springSecurity.springSecurity_second.service.ServiceImplementation;

import com.springSecurity.springSecurity_second.Repository.UserRepository;
import com.springSecurity.springSecurity_second.models.Users;
import com.springSecurity.springSecurity_second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> findUserByName(String name) {
        return  userRepository.findUsersByName(name);
    }

    @Override
    public String saveUser(Users users) {
        Users users1=userRepository.save(users);

//        check if the user is  saved
        if(!Objects.equals(users1.getName(), "")){
            return "user added successfully";
        }
        return "failed to add user !,please try again";
    }


}
