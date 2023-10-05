package com.springSecurity.springSecurity_second.controller;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {

    private String email;
    private String password;
}
