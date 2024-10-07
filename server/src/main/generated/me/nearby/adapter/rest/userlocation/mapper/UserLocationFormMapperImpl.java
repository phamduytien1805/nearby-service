package me.nearby.adapter.rest.userlocation.mapper;

import java.util.UUID;
import javax.annotation.processing.Generated;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.userlocation.UserLocation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T22:59:02+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserLocationFormMapperImpl implements UserLocationFormMapper {

    @Override
    public UserLocation mapToDomain(UserLocationForm form, UUID userId, Integer radius) {
        if ( form == null ) {
            return null;
        }

        UserLocation userLocation = new UserLocation();

        userLocation.setLatitude( form.getLatitude() );
        userLocation.setLongitude( form.getLongitude() );

        setUserId( userLocation, userId );
        setS2CellId( userLocation, radius );

        return userLocation;
    }
}
