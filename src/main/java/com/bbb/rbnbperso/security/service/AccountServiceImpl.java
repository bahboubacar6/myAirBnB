package com.bbb.rbnbperso.security.service;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.entities.Role;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.mappers.AppUserMapper;
import com.bbb.rbnbperso.repositories.AppUserRepository;
import com.bbb.rbnbperso.repositories.RoleRepository;
import com.bbb.rbnbperso.services.GestationServiceImp;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private RoleRepository roleRepository;
    private AppUserMapper appUserMapper;
    private GestationServiceImp dtoMapper;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository, AppUserMapper appUserMapper, GestationServiceImp dtoMapper, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.appUserMapper = appUserMapper;
        this.dtoMapper = dtoMapper;
        this.passwordEncoder = passwordEncoder;
    }

   @Override
    public AppUserDTO addNewUser(AppUserDTO appUserDTO) {
        AppUser appUser = appUserMapper.toEntity(appUserDTO);
        AppUser appUserSaved = appUserRepository.save(appUser);
        AppUserDTO appUserDTOSaved = appUserMapper.toDto(appUserSaved);
        return appUserDTOSaved;
    }

    @Override
    public AppUserDTO saveUser(AppUserDTO appUserDTO) {
        appUserRepository.findByEmail(appUserDTO.getEmail()).ifPresent(
                (present)->{
                    throw new RuntimeException("L'utilisateur exist déjà");
                }
        );
        AppUser appUser = appUserMapper.toEntity(appUserDTO);
        appUser.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));
        Role role = roleRepository.findByRoleName("USER");
        appUser.setListRoles(List.of(role));
        //appUser.getListRoles().add(role);
        AppUser appUserSaved = appUserRepository.save(appUser);
        return appUserMapper.toDto(appUserSaved);
    }

    @Override
    public AppUserDTO updateUser(AppUserDTO appUserDTO) throws UserNotFoundException {
        AppUser appUser = appUserRepository.findById(appUserDTO.getIdUser()).get();

        if(appUser == null){
            throw new UserNotFoundException("L'utilisateur n'est pas connecté");
        }
        if(!Objects.equals(appUser.getEmail(),appUserDTO.getEmail())){
            appUser.setEmail(appUserDTO.getEmail());
        }
        if(!Objects.equals(appUser.getPassword(),appUserDTO.getPassword())){
            appUser.setPassword(appUserDTO.getPassword());
        }
        AppUser userSaved = appUserRepository.save(appUser);
        AppUserDTO userDTOSaved = appUserMapper.toDto(userSaved);
        return userDTOSaved;
    }

  /* @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }*/

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        appUser.getListRoles().add(role);
    }

    @Override
    public AppUserDTO loadUserByUserName(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);
        return appUserDTO;
    }

    @Override
    public List<AppUserDTO> listUsers() {
        List<AppUser> users = appUserRepository.findAll();
        List<AppUserDTO> appUserDTOS = users.stream().map(u -> appUserMapper.toDto(u)).collect(Collectors.toList());
        return appUserDTOS;
    }

    @Override
    public List<AppUser> listeUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUserDTO findByEmail(String email) throws UserNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User not found"));
        return appUserMapper.toDto(appUser);
    }
}
