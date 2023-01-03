package com.bbb.rbnbperso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;
    private String roleName;
    @ManyToMany
    @JoinTable(name = "AppUser_Role",
               joinColumns = @JoinColumn(name = "id_role"),
               inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<AppUser> userList = new ArrayList<>();
}
