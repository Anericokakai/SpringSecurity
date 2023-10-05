package com.springSecurity.springSecurity_second.Repository;

import com.springSecurity.springSecurity_second.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository  extends JpaRepository<Users, Integer> {


    Optional<Users> findByEmail(String email);
}
