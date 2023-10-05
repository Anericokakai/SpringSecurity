package com.springSecurity.springSecurity_second.models;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Table(name = "roles")
public enum Role {
    USER,
          ADMIN

}
