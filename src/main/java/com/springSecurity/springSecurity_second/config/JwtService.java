package com.springSecurity.springSecurity_second.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


//! add the service annotation to make it transform to a manged bean
@Service
public class JwtService {


//    ! we need a secrete key to hash
private final String SECRET_kEY="15B8B378C8F2217A8F75418211F78";

    public String exctractUserName(String token) {

//   !     extract the username
        return  extractClaim(token, Claims::getSubject);

    }



    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return  claimsResolver.apply(claims);
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

    //    ! create a new token

    public  String generateToken(
            Map<String,Object>  extraCliams,
            UserDetails userDetails
    ){return Jwts.builder()
            .setClaims(extraCliams)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*1))
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact();


    }

//    ! generate  a token without extra claims

  public String  generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
  }

//  validate the token

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username=exctractUserName(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
return extractExpiration(token).before(new Date());

    }

    private Date extractExpiration(String token) {
return extractClaim(token, Claims::getExpiration);

    }


}
