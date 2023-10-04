package com.springSecurity.springSecurity_second.Repository;

import com.springSecurity.springSecurity_second.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM  users WHERE name=?1",nativeQuery = true)
    Optional<Users> findUsersByName(String name);
}
