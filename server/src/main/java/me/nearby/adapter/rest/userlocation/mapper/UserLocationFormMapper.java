package me.nearby.adapter.rest.userlocation.mapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.domain.geometry.usecase.GeometryUseCaseImpl;
import me.nearby.domain.geometry.usecase.RadiusConfig;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserLocationFormMapper {
    UserLocationFormMapper BUILDER = Mappers.getMapper(UserLocationFormMapper.class);

    // Map fields from UserLocationForm to UserLocation
    UserLocation mapToDomain(@Context UUID userId,@Context Integer radius, UserLocationForm form);

    @AfterMapping
    default void setUserId(@MappingTarget UserLocation userLocation, @Context UUID userId) {
        userLocation.setUserId(userId);
    }

    @AfterMapping
    default void setS2CellId(@MappingTarget UserLocation userLocation, @Context Integer radius) {
        userLocation.setS2CellId(GeometryUseCaseImpl.getCellId(userLocation.getLatitude(), userLocation.getLongitude(), RadiusConfig.findByValue(radius)));
    }
}
