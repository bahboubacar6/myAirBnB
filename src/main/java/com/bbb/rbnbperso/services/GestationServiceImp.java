package com.bbb.rbnbperso.services;

import com.bbb.rbnbperso.dtos.*;
import com.bbb.rbnbperso.entities.*;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.exceptions.AvisNotFoundException;
import com.bbb.rbnbperso.exceptions.ReservationNotFoundException;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.mappers.GestationMapperImp;
import com.bbb.rbnbperso.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class GestationServiceImp implements GestationService {

    private AnnounceRepository announceRepository;
    private AppUserRepository appUserRepository;
    private AvisRepository avisRepository;
    private ReservationRepository reservationRepository;
    private RoleRepository roleRepository;
    private GestationMapperImp dtoMappers;

    @Override
    public AppUserDTO saveUser(AppUserDTO appUserDTO) {
        log.info("Saving User");
        AppUser appUser = dtoMappers.fromAppUserDTO(appUserDTO);
        AppUser savedUser = appUserRepository.save(appUser);
        return dtoMappers.fromAppUser(savedUser);
    }
    @Override
    public AppUserDTO updateUser(AppUserDTO appUserDTO) {
        log.info("Saving User");
        AppUser appUser = dtoMappers.fromAppUserDTO(appUserDTO);
        AppUser savedUser = appUserRepository.save(appUser);
        return dtoMappers.fromAppUser(savedUser);
    }
    @Override
    public void deleteAppUser(Long idUser){
        appUserRepository.deleteById(idUser);
    }
    @Override
    public List<AppUserDTO> listUsers() {
        List<AppUser> userList = appUserRepository.findAll();
        List<AppUserDTO> appUserDTOS = userList.stream().map(user -> dtoMappers.fromAppUser(user)).collect(Collectors.toList());
        return appUserDTOS;
    }
    @Override
    public AppUserDTO getUser(Long idUser) throws UserNotFoundException {
        AppUser appUser = appUserRepository.findById(idUser).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        AppUserDTO appUserDTO = dtoMappers.fromAppUser(appUser);
        return appUserDTO;
    }
    @Override
    public AnnounceDTO saveAnnounce(AnnounceDTO announceDTO){
        Announce announce = dtoMappers.fromAnnounceDTO(announceDTO);
        Announce savedAnnounce = announceRepository.save(announce);
        AnnounceDTO savedAnnounceDTO = dtoMappers.fromAnnounce(savedAnnounce);
        return savedAnnounceDTO;
    }
    @Override
    public AnnounceDTO updateAnnounce(AnnounceDTO announceDTO){
        Announce announce = dtoMappers.fromAnnounceDTO(announceDTO);
        Announce savedAnnounce = announceRepository.save(announce);
        AnnounceDTO savedAnnounceDTO = dtoMappers.fromAnnounce(savedAnnounce);
        return savedAnnounceDTO;
    }
    @Override
    public void deleteAnnounce(Long idAnnounce){
         announceRepository.deleteById(idAnnounce);
    }
    @Override
    public AnnounceDTO getAnnounce(Long idAnnounce) throws AnnounceNotFoundException {
        Announce announce = announceRepository.findById(idAnnounce).orElseThrow(()->new AnnounceNotFoundException("Announce Not Found"));
        return dtoMappers.fromAnnounce(announce);
    }
    @Override
    public List<AnnounceDTO> listAnnounces() {
        List<Announce> announceList = announceRepository.findAll();
        List<AnnounceDTO> announceDTOList = announceList.stream().map(announce -> dtoMappers.fromAnnounce(announce)).collect(Collectors.toList());
        return announceDTOList;
    }
    @Override
    public RoleDTO saveRole(RoleDTO roleDTO){
        Role role = dtoMappers.fromRoleDTO(roleDTO);
        Role savedRole = roleRepository.save(role);
        RoleDTO savedRoleDTO = dtoMappers.fromRole(savedRole);
        return savedRoleDTO;
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO){
        Role role = dtoMappers.fromRoleDTO(roleDTO);
        Role savedRole = roleRepository.save(role);
        RoleDTO savedRoleDTO = dtoMappers.fromRole(savedRole);
        return savedRoleDTO;
    }
    @Override
    public void deleteRole(Long idRole){
        roleRepository.deleteById(idRole);
    }
    @Override
    public RoleDTO getRole(Long idRole) throws RoleNotFoundException {
        Role role = roleRepository.findById(idRole).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
        return dtoMappers.fromRole(role);
    }
    @Override
    public List<RoleDTO> listRoles(){
        List<Role> roleList = roleRepository.findAll();
        List<RoleDTO> roleDTOList = roleList.stream().map(role -> dtoMappers.fromRole(role)).collect(Collectors.toList());
        return roleDTOList;
    }
    @Override
    public ReservationDTO saveReservation(ReservationDTO reservationDTO){
        Reservation reservation = dtoMappers.fromReservationDTO(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        ReservationDTO savedReservationDTO = dtoMappers.fromReservation(savedReservation);
        return savedReservationDTO;
    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO){
        Reservation reservation = dtoMappers.fromReservationDTO(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        ReservationDTO savedReservationDTO = dtoMappers.fromReservation(savedReservation);
        return savedReservationDTO;
    }
    @Override
    public void deleteReservation(Long idReservation){
        reservationRepository.deleteById(idReservation);
    }
    @Override
    public ReservationDTO getReservation(Long idReservation) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(idReservation).orElseThrow(()->new ReservationNotFoundException("Reservation Not Found"));
        return dtoMappers.fromReservation(reservation);
    }
    @Override
    public List<ReservationDTO> listReservations() {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOList = reservationList.stream().map(reservation -> dtoMappers.fromReservation(reservation)).collect(Collectors.toList());
        return reservationDTOList;
    }
    @Override
    public AvisDTO saveAvis(AvisDTO avisDTO){
        Avis avis = dtoMappers.fromAvisDTO(avisDTO);
        Avis savedAvis = avisRepository.save(avis);
        AvisDTO savedAvisDTO = dtoMappers.fromAvis(savedAvis);
        return savedAvisDTO;
    }
    @Override
    public AvisDTO updateAvis(AvisDTO avisDTO){
        Avis avis = dtoMappers.fromAvisDTO(avisDTO);
        Avis savedAvis = avisRepository.save(avis);
        AvisDTO savedAvisDTO = dtoMappers.fromAvis(savedAvis);
        return savedAvisDTO;
    }
    @Override
    public void deleteAvis(Long idAvis){
        avisRepository.deleteById(idAvis);
    }
    @Override
    public AvisDTO getAvis(Long idAvis) throws AvisNotFoundException {
        Avis avis = avisRepository.findById(idAvis).orElseThrow(() -> new AvisNotFoundException("Avis Not Found"));
        AvisDTO avisDTO = dtoMappers.fromAvis(avis);
        return avisDTO;
    }
    @Override
    public List<AvisDTO> listAvis(){
        List<Avis> avisList = avisRepository.findAll();
        List<AvisDTO> avisDTOSList = avisList.stream().map(avis -> dtoMappers.fromAvis(avis)).collect(Collectors.toList());
        return avisDTOSList;
    }
}
