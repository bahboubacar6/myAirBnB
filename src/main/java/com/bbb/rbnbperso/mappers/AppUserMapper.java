package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.entities.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUser toEntity(AppUserDTO appUserDTO);
    AppUserDTO toDto(AppUser appUser);
}
