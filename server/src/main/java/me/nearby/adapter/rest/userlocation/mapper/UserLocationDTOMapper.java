package me.nearby.adapter.rest.userlocation.mapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.domain.geometry.usecase.GeometryUseCaseImpl;
import me.nearby.spring.converter.RestConverter;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserLocationDTOMapper extends RestConverter<UserLocationDTO, UserLocation> {
    UserLocationDTOMapper BUILDER = Mappers.getMapper(UserLocationDTOMapper.class);

    UserLocationDTO mapToDTO(UserLocation form);

}
