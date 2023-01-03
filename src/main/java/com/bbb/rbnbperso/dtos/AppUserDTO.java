package com.bbb.rbnbperso.dtos;

import lombok.Data;

@Data
public class AppUserDTO {
    private Long idUser;
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
}
