package com.bbb.rbnbperso.entities;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;
    @Enumerated(EnumType.STRING)
    private TypeAR typeReservation;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
    private Double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private AppUser appUser;
    @OneToMany(targetEntity = Avis.class, mappedBy = "reservation")
    private List<Avis> avisList = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "id_announce", nullable = false)
    private Announce announce;
}
