package me.nearby.adapter.rest.userlocation.mapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Mapper
@Component
public interface UserLocationFormMapper {
    UserLocationFormMapper BUILDER = Mappers.getMapper(UserLocationFormMapper.class);

    // Map fields from UserLocationForm to UserLocation
    UserLocation mapToDomain(@Context UUID id, UserLocationForm form);

    // After mapping, set the ID
    @AfterMapping
    default void setId(@MappingTarget UserLocation userLocation, @Context UUID id) {
        userLocation.setId(id);
    }
}
