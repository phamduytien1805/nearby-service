package me.nearby.adapter.rest.userlocation.mapper;

import java.util.UUID;
import javax.annotation.processing.Generated;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.userlocation.UserLocation;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T17:05:39+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class UserLocationFormMapperImpl implements UserLocationFormMapper {

    @Override
    public UserLocation mapToDomain(UUID id, UserLocationForm form) {
        if ( form == null ) {
            return null;
        }

        UserLocation userLocation = new UserLocation();

        setId( userLocation, id );

        return userLocation;
    }
}
