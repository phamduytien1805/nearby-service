package me.nearby.adapter.rest.userlocation.mapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.spring.converter.RestConverter;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserLocationFormMapper {
    UserLocationFormMapper BUILDER = Mappers.getMapper(UserLocationFormMapper.class);

    // Map fields from UserLocationForm to UserLocation
    UserLocation mapToDomain(@Context UUID userId, UserLocationForm form);

    // After mapping, set the ID
    @AfterMapping
    default void setUserId(@MappingTarget UserLocation userLocation, @Context UUID userId) {
        userLocation.setUserId(userId);
    }
}
