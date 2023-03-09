package com.bbb.rbnbperso.security;

import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.repositories.AppUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

@Component
public class JWTGenerator {

    private static final String USER_NOT_FOUND = "Utilisateur n'existe pas";
    @Autowired
    private AppUserRepository appUserRepository;

    public String generateToken(Authentication authentication) throws UserNotFoundException {
        String username = authentication.getName();
        AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(
                () -> new UserNotFoundException(USER_NOT_FOUND)
        );
        Collection<? extends GrantedAuthority> authorities =
                authentication.getAuthorities();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", authorities)
                .claim("idUser", appUser.getIdUser())
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .compact();
    }

    public String getUsernameFromJWT(String jwtToken) {
        //String token = jwtToken.split(" ")[1]
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims.getSubject();
    }
    public Integer getIdFromJWT(String jwtToken) {
        String token = jwtToken.split(" ")[1];
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return (Integer) claims.get("id");
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }
}
