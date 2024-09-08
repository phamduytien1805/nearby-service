package me.nearby.adapter.datastorage.userlocation.mapper;

import me.nearby.persistence.userlocation.UserLocationEntity;
import me.nearby.spring.shared.repository.RepositoryConverter;
import me.nearby.userlocation.UserLocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserLocationGatewayMapper extends RepositoryConverter<UserLocationEntity, UserLocation> {
    public static final UserLocationGatewayMapper INSTANCE = Mappers.getMapper(UserLocationGatewayMapper.class);

    @Override
    UserLocationEntity mapToTableNotNull(UserLocation persistenceObject);

    @Override
    UserLocation mapToEntityNotNull(UserLocationEntity tableObject);

}
