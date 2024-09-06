package me.nearby.adapter.rest.userlocation.mapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserLocationDTOMapper {
    UserLocationDTOMapper BUILDER = Mappers.getMapper(UserLocationDTOMapper.class);

    UserLocationDTO mapToDTO(UserLocation form);

}
