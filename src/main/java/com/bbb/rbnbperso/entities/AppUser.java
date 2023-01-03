package com.bbb.rbnbperso.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "AppUser_Role",
                joinColumns = @JoinColumn(name = "id_user"),
                inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roleList = new ArrayList<>();
    @OneToMany(targetEntity = Announce.class, mappedBy = "appUser")
    private List<Announce> announceList = new ArrayList<>();
    @OneToMany(targetEntity = Reservation.class, mappedBy = "appUser")
    private List<Reservation> reservationList = new ArrayList<>();
    @OneToMany(targetEntity = Avis.class, mappedBy = "appUser")
    private List<Avis> avisList = new ArrayList<>();
}
