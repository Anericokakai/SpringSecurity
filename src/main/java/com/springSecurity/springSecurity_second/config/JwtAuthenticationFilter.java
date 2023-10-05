package com.springSecurity.springSecurity_second.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;


    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader=request.getHeader("Authorization");

        final String jwt;
        final String userEmail;
if(authHeader==null||!authHeader.startsWith("Bearer")){
filterChain.doFilter(request,response);
}

//todoExtract the token from the header

        jwt=authHeader.substring(7);
//! get rid of the bearer using the substring to remove the seven first words

//todoextract the userEmail from the token
userEmail=jwtService.exctractUserName(jwt);


    }
}
