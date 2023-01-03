package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ReservationDTO {

    private Long idReservation;
    private TypeAR typeReservation;
    private LocalDateTime date;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String image;
    private AppUserDTO appUserDTO;
    private AnnounceDTO announceDTO;
}
