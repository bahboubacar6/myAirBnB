package com.bbb.rbnbperso.dtos;

import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.enums.TypeAR;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnounceDTO {

    private Long idAnnounce;
    private TypeAR typeAnnounce;
    private LocalDateTime date;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String image;
    private AppUserDTO appUserDTO;
}
