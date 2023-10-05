package com.springSecurity.springSecurity_second.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;


//! add the service annotation to make it transform to a manged bean
@Service
public class JwtService {


//    ! we need a secrete key to hash
private final String SECRET_kEY="15B8B378C8F2217A8F75418211F78";

    public String exctractUserName(String jwt) {
        return  null;
    }

    private Claims extractAllClaims(String token){


        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
byte[] keyBytes= Decoders.BASE64.decode(SECRET_kEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
