package com.bbb.rbnbperso.security.service;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.dtos.RoleDTO;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.entities.Role;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;

import java.util.List;

public interface AccountService {
    //AppUser addNewUser(AppUser appUser);
    AppUserDTO addNewUser(AppUserDTO appUserDTO);
    AppUserDTO saveUser(AppUserDTO appUserDTO);
    AppUserDTO updateUser(AppUserDTO appUserDTO) throws UserNotFoundException;
    Role addNewRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUserDTO loadUserByUserName(String username);
    List<AppUserDTO> listUsers();
    List<AppUser> listeUsers();
    AppUserDTO findByEmail(String email) throws UserNotFoundException;
}
