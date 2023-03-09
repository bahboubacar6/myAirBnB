package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.security.SecurityConstants;
import lombok.Data;

@Data
public class AuthResponseDTO {

    private String accessToken;
    private String tokenType = "Bearer ";
    private long expiresIn = SecurityConstants.JWT_EXPIRATION;
    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
