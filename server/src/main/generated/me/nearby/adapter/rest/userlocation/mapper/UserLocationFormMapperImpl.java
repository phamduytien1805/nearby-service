package me.nearby.adapter.rest.userlocation.mapper;

import java.util.UUID;
import javax.annotation.processing.Generated;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.userlocation.UserLocation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-06T13:21:28+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserLocationFormMapperImpl implements UserLocationFormMapper {

    @Override
    public UserLocation mapToDomain(UUID userId, Integer radius, UserLocationForm form) {
        if ( form == null ) {
            return null;
        }

        UserLocation userLocation = new UserLocation();

        setUserId( userLocation, userId );
        setS2CellId( userLocation, radius );

        return userLocation;
    }
}
