package com.springSecurity.springSecurity_second.service;

import com.springSecurity.springSecurity_second.Repository.UserRepository;
import com.springSecurity.springSecurity_second.config.JwtService;
import com.springSecurity.springSecurity_second.controller.AuthenticationRequest;
import com.springSecurity.springSecurity_second.controller.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
private final AuthenticationManager authenticationManager;
private final UserRepository  userRepository;
private final JwtService jwtService;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=userRepository.findByEmail(request.getEmail())
                .orElseThrow();
//  generate the token
         var jwtToken=jwtService.generateToken(user);
         return AuthenticationResponse.builder()
                 .token(jwtToken).build();

    }
}
