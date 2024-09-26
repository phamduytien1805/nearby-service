package me.nearby.adapter.rest.userlocation.mapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.spring.converter.RestConverter;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserLocationDTOMapper extends RestConverter<UserLocationDTO, UserLocation> {
    UserLocationDTOMapper BUILDER = Mappers.getMapper(UserLocationDTOMapper.class);

    UserLocationDTO mapToDTO(UserLocation form);

//    UserLocation mapToEntity(UserLocationDTO dto);
}
