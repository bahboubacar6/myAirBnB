package com.bbb.rbnbperso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "id_reservation", nullable = false)
    private Reservation reservation;
}
