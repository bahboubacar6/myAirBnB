package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.*;
import com.bbb.rbnbperso.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GestationMapperImp {

    public AppUserDTO fromAppUser(AppUser appUser){
        AppUserDTO appUserDTO = new AppUserDTO();
        BeanUtils.copyProperties(appUser, appUserDTO);
        return appUserDTO;
    }

    public AppUser fromAppUserDTO(AppUserDTO appUserDTO){
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDTO,appUser);
        return appUser;
    }

    public AnnounceDTO fromAnnounce(Announce announce){
        AnnounceDTO announceDTO = new AnnounceDTO();
        BeanUtils.copyProperties(announce, announceDTO);
        announceDTO.setAppUserDTO(fromAppUser(announce.getAppUser()));
        return announceDTO;
    }

    public Announce fromAnnounceDTO(AnnounceDTO announceDTO){
        Announce announce = new Announce();
        BeanUtils.copyProperties(announceDTO, announce);
        announce.setAppUser(fromAppUserDTO(announceDTO.getAppUserDTO()));
        return announce;
    }

    public RoleDTO fromRole(Role role){
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(role,roleDTO);
        return roleDTO;
    }

    public Role fromRoleDTO(RoleDTO roleDTO){
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return  role;
    }

    public ReservationDTO fromReservation(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        BeanUtils.copyProperties(reservation, reservationDTO);
        reservationDTO.setAppUserDTO(fromAppUser(reservation.getAppUser()));
        reservationDTO.setAnnounceDTO(fromAnnounce(reservation.getAnnounce()));
        return reservationDTO;
    }

    public Reservation fromReservationDTO(ReservationDTO reservationDTO){
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDTO, reservation);
        reservation.setAppUser(fromAppUserDTO(reservationDTO.getAppUserDTO()));
        reservation.setAnnounce(fromAnnounceDTO(reservationDTO.getAnnounceDTO()));
        return reservation;
    }

    public AvisDTO fromAvis(Avis avis){
        AvisDTO avisDTO = new AvisDTO();
        BeanUtils.copyProperties(avis, avisDTO);
        avisDTO.setIdUserDTO(fromAppUser(avis.getAppUser()).getIdUser());
        avisDTO.setIdReservationDTO(fromReservation(avis.getReservation()).getIdReservation());
        return avisDTO;
    }

    public Avis fromAvisDTO(AvisDTO avisDTO){
        Avis avis = new Avis();
        BeanUtils.copyProperties(avisDTO, avis);
        avis.setAppUser(fromAppUserDTO(avisDTO.getAppUserDTO()));
        avis.setReservation(fromReservationDTO(avisDTO.getReservationDTO()));
        return avis;
    }
}
