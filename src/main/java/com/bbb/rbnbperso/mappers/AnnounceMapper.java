package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.AnnounceDTO;
import com.bbb.rbnbperso.entities.Announce;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ImageModelMapper.class)
public interface AnnounceMapper {


    Announce toEntity(AnnounceDTO announceDTO);
    AnnounceDTO toDto(Announce announce);
}
