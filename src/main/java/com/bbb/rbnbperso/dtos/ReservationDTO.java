package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ReservationDTO {

    private Long idReservation;
    private TypeAR typeReservation;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
    private Double price;
    private String description;
    private AppUserDTO appUserDTO;
    private AnnounceDTO announceDTO;
}
