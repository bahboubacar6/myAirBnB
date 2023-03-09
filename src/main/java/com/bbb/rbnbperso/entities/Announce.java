package com.bbb.rbnbperso.entities;

import com.bbb.rbnbperso.enums.TypeAR;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_announce")
    private Long idAnnounce;
    @Enumerated(EnumType.STRING)
    private TypeAR typeAnnounce;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
    private Double price;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "announce_images",
                joinColumns = {
                    @JoinColumn(name = "id_announce")
                },
                inverseJoinColumns = {
                    @JoinColumn(name = "id_image")
                }
                )
    private Set<ImageModel> announceImages;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    //@JsonBackReference
    private AppUser appUser;
    @OneToOne(mappedBy = "announce")
    private Reservation reservation;
}
