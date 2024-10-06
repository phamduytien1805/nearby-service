package me.nearby.adapter.datastorage.userlocation.mapper;

import javax.annotation.processing.Generated;
import me.nearby.persistence.userlocation.UserLocationEntity;
import me.nearby.userlocation.UserLocation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T09:30:49+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserLocationGatewayMapperImpl implements UserLocationGatewayMapper {

    @Override
    public UserLocationEntity mapToTableNotNull(UserLocation persistenceObject) {
        if ( persistenceObject == null ) {
            return null;
        }

        UserLocationEntity userLocationEntity = new UserLocationEntity();

        userLocationEntity.setId( persistenceObject.getId() );
        userLocationEntity.setUserId( persistenceObject.getUserId() );
        userLocationEntity.setLatitude( persistenceObject.getLatitude() );
        userLocationEntity.setLongitude( persistenceObject.getLongitude() );
        userLocationEntity.setS2CellId( persistenceObject.getS2CellId() );

        return userLocationEntity;
    }

    @Override
    public UserLocation mapToEntityNotNull(UserLocationEntity tableObject) {
        if ( tableObject == null ) {
            return null;
        }

        UserLocation userLocation = new UserLocation();

        userLocation.setId( tableObject.getId() );
        userLocation.setUserId( tableObject.getUserId() );
        userLocation.setLatitude( tableObject.getLatitude() );
        userLocation.setLongitude( tableObject.getLongitude() );
        userLocation.setS2CellId( tableObject.getS2CellId() );

        return userLocation;
    }
}
