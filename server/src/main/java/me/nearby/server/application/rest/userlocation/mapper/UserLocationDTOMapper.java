package me.nearby.server.application.rest.userlocation.mapper;

import me.nearby.domain.userlocation.UserLocation;
import me.nearby.server.ports.inbound.rest.userlocation.dto.UserLocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserLocationDTOMapper {
    UserLocationDTOMapper BUILDER = Mappers.getMapper(UserLocationDTOMapper.class);

    UserLocationDTO mapToDTO(UserLocation form);

}
