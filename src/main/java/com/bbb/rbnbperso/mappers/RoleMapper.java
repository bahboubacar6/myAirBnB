package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.RoleDTO;
import com.bbb.rbnbperso.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDto(Role role);
}
