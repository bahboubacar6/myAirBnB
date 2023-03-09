package com.bbb.rbnbperso.mappers;

import com.bbb.rbnbperso.dtos.ImageModelDTO;
import com.bbb.rbnbperso.entities.ImageModel;
import org.mapstruct.Mapper;

import javax.persistence.SecondaryTable;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ImageModelMapper {

    ImageModel toEntity(ImageModelDTO imageModelDTO);

    ImageModelDTO toDto(ImageModel imageModel);

    Set<ImageModel> toEntityList(Set<ImageModelDTO> imageModelDTOs);

    Set<ImageModelDTO> toDtoList(Set<ImageModel> imageModels);
}
