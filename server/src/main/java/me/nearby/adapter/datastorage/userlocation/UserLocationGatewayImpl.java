package me.nearby.adapter.datastorage.userlocation;

import lombok.AllArgsConstructor;
import me.nearby.adapter.datastorage.userlocation.mapper.UserLocationGatewayMapper;
import me.nearby.persistence.userlocation.UserLocationEntity;
import me.nearby.persistence.userlocation.repository.UserLocationRepository;
import me.nearby.spring.repository.AbstractJPARepositoryGateway;
import me.nearby.spring.repository.RepositoryConverter;
import me.nearby.userlocation.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
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
    public List<UserLocation> findByS2CellIdIn(Collection<Long> s2CellIds) {
        return userLocationRepository.findByS2CellIdIn(s2CellIds).stream().map(userLocationMapper::mapToEntity).toList();
    }
}










