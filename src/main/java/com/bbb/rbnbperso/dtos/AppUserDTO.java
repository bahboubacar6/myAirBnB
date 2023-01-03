package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.entities.AppUser;
import lombok.Data;

@Data
public class AppUserDTO {
/*    public AppUserDTO(){}

    public AppUserDTO(Long idUser, String lastName, String firstName, String email, String username, String password) {
        this.idUser = idUser;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public AppUserDTO(AppUser appUser) {
        this(appUser.getIdUser(), appUser.getLastName(), appUser.getFirstName(), appUser.getEmail(),appUser.getUsername(), appUser.getPassword());
    }*/
    private Long idUser;
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
}
