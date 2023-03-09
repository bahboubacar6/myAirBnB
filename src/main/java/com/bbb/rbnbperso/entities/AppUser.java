package com.bbb.rbnbperso.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    private String lastName;
    private String firstName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
   /* @JoinTable(name = "app_user_list_roles",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_role")}
    )*/
    private List<Role> listRoles = new ArrayList<>();
    //private Set<Role> listRoles = new HashSet<>();
    @OneToMany(targetEntity = Announce.class, mappedBy = "appUser")
    //@JsonManagedReference
    private List<Announce> announceList = new ArrayList<>();
    @OneToMany(targetEntity = Reservation.class, mappedBy = "appUser")
    //@JsonManagedReference
    private List<Reservation> reservationList = new ArrayList<>();
    @OneToMany(targetEntity = Avis.class, mappedBy = "appUser")
    //@JsonManagedReference
    private List<Avis> avisList = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(idUser, appUser.idUser) && Objects.equals(lastName, appUser.lastName) && Objects.equals(firstName, appUser.firstName) && Objects.equals(email, appUser.email) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(listRoles, appUser.listRoles) && Objects.equals(announceList, appUser.announceList) && Objects.equals(reservationList, appUser.reservationList) && Objects.equals(avisList, appUser.avisList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, lastName, firstName, email, username, password, listRoles, announceList, reservationList, avisList);
    }

    public void ifPresent(Object o) {
    }
}
