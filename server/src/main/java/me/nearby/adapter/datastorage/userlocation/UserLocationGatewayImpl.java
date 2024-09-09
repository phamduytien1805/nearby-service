package me.nearby.adapter.datastorage.userlocation;

import lombok.AllArgsConstructor;
import me.nearby.adapter.datastorage.userlocation.mapper.UserLocationGatewayMapper;
import me.nearby.persistence.userlocation.UserLocationEntity;
import me.nearby.persistence.userlocation.repository.UserLocationRepository;
import me.nearby.spring.shared.repository.AbstractJPARepositoryGateway;
import me.nearby.spring.shared.repository.AbstractRepositoryGateway;
import me.nearby.spring.shared.repository.RepositoryConverter;
import me.nearby.userlocation.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserLocationGatewayImpl extends AbstractJPARepositoryGateway<UserLocation, UserLocationEntity, String> implements UserLocationGateway {
  private final UserLocationRepository userLocationRepository;
  private final UserLocationGatewayMapper userLocationMapper = UserLocationGatewayMapper.INSTANCE;

    @Override
    protected <A extends JpaRepository<UserLocationEntity, String>> A getJPARepository() {
        return (A) userLocationRepository;
    }

    @Override
    protected <A extends ListCrudRepository<UserLocationEntity, String>> A getRepository() {
        return (A) userLocationRepository;
    }

    @Override
    protected <A extends RepositoryConverter<UserLocationEntity, UserLocation>> A getRepositoryConverter() {
        return (A) userLocationMapper;
    }

    @Override
    public UserLocation saveUserLocation(UserLocation userLocation) {
        return this.saveAndFlush(userLocation);
    }

}










