package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.entities.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface AppUserMapper {

    @Mapping(source = "roles", target = "listRoles")
    AppUser toEntity(AppUserDTO appUserDTO);
    @Mapping(target = "roles", source = "listRoles")
    AppUserDTO toDto(AppUser appUser);
}
