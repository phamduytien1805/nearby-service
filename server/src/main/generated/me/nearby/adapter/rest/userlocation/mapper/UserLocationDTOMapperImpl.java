package me.nearby.adapter.rest.userlocation.mapper;

import javax.annotation.processing.Generated;
import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.userlocation.UserLocation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T23:01:35+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserLocationDTOMapperImpl implements UserLocationDTOMapper {

    @Override
    public UserLocationDTO mapToRest(UserLocation form) {
        if ( form == null ) {
            return null;
        }

        UserLocationDTO userLocationDTO = new UserLocationDTO();

        userLocationDTO.setUserId( form.getUserId() );
        userLocationDTO.setLatitude( form.getLatitude() );
        userLocationDTO.setLongitude( form.getLongitude() );

        return userLocationDTO;
    }
}
