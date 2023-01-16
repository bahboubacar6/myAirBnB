package com.bbb.rbnbperso.dtos;

import lombok.Data;

import java.time.LocalDate;


@Data
public class AvisDTO {

    private Long id;
    private String message;
    private LocalDate date;
    private AppUserDTO appUserDTO;
    private ReservationDTO reservationDTO;
    private Long idUserDTO;
    private Long idReservationDTO;
}
