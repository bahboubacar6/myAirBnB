package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.enums.TypeAR;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class AnnounceDTO {

    private Long idAnnounce;
    private TypeAR typeAnnounce;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String image;
    private Double price;
    private String description;
    private Set<ImageModelDTO> announceImages;
    private Long idUser;
}
