package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ReservationFormDTO {

    private Long idReservation;
    private TypeAR typeReservation;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
    private Double price;
    private String description;
    private Long idAppUserDTO;
    private Long idAnnounceDTO;
}
