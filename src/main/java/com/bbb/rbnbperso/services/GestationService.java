package com.bbb.rbnbperso.services;

import com.bbb.rbnbperso.dtos.*;
import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.entities.Reservation;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.exceptions.AvisNotFoundException;
import com.bbb.rbnbperso.exceptions.ReservationNotFoundException;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface GestationService {
    AppUserDTO saveUser(AppUserDTO appUserDTO);

    AppUserDTO updateUser(AppUserDTO appUserDTO);

    void deleteAppUser(Long idUser);

    List<AppUserDTO> listUsers();
    AppUserDTO getUser(Long idUser) throws UserNotFoundException;
    List<AnnounceDTO> listAnnounces();
    AnnounceDTO saveAnnounce(AnnounceDTO announceDTO);

    AnnounceDTO saveAnnounceDB(AnnounceDTO announceDTO) throws IOException;

    AnnounceDTO updateAnnounce(AnnounceDTO announceDTO);

    void deleteAnnounce(Long idAnnounce);
    AnnounceDTO getAnnounce(Long idAnnounce) throws AnnounceNotFoundException;

    void deleteRole(Long idRole);

    RoleDTO getRole(Long idRole) throws RoleNotFoundException;

    List<RoleDTO> listRoles();

    List<ReservationDTO> listReservations();

    RoleDTO saveRole(RoleDTO roleDTO);

    RoleDTO updateRole(RoleDTO roleDTO);

    ReservationDTO saveReservation(ReservationDTO reservationDTO);

    ReservationDTO updateReservation(ReservationDTO reservationDTO);

    void deleteReservation(Long idReservation);

    ReservationDTO getReservation(Long idReservation) throws ReservationNotFoundException;

    AvisDTO saveAvis(AvisDTO avisDTO);

    AvisDTO updateAvis(AvisDTO avisDTO);

    void deleteAvis(Long idAvis);

    AvisDTO getAvis(Long idAvis) throws AvisNotFoundException ;

    List<AvisDTO> listAvis();


    ReservationDTO addReservationToUser(ReservationFormDTO reservationFormDTO) throws Exception;


    List<AnnounceDTO> announcesUser(Long idUser);

    List<AppUserDTO> searchUsers(String kw);

    List<AnnounceDTO> searchAnnounces(TypeAR kw);

    byte [] getImageOfAnnonce(long idImage);
}
