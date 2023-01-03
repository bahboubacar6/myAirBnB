package com.bbb.rbnbperso.entities;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_announce")
    private Long idAnnounce;
    @Enumerated(EnumType.STRING)
    private TypeAR typeAnnounce;
    private LocalDateTime date;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private AppUser appUser;
    @OneToOne(mappedBy = "announce")
    private Reservation reservation;
}
