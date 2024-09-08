package com.pagatodo.test.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    @Value("${secret.word}")
    private String secret;

    public String getUsername(String token){
        return getClaims(token, Claims::getSubject);
    }

    public Date getExpiration(String token){
        return getClaims(token, Claims::getExpiration);
    }

    public <T> T getClaims(String token, Function<Claims, T> claimsResolve){
        final Claims claims = extractAllClaims(token);
        return claimsResolve.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
    }

    private Boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

    public String generateToken(String username, String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject){
        String jwt = Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 10))
        .signWith(SignatureAlgorithm.HS256, secret).compact();
        return jwt;
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
