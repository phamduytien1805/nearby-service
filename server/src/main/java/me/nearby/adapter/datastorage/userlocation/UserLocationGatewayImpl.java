package me.nearby.adapter.datastorage.userlocation;

import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import me.nearby.adapter.datastorage.userlocation.mapper.UserLocationGatewayMapper;
import me.nearby.persistence.userlocation.UserLocationEntity;
import me.nearby.persistence.userlocation.repository.UserLocationRepository;
import me.nearby.spring.repository.AbstractCrudRepositoryGateway;
import me.nearby.spring.repository.AbstractRepositoryGateway;
import me.nearby.spring.repository.RepositoryConverter;
import me.nearby.userlocation.UserLocation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
public class UserLocationGatewayImpl extends AbstractCrudRepositoryGateway<UserLocation, UserLocationEntity, String> implements UserLocationGateway {
    private final UserLocationRepository userLocationRepository;
    private final UserLocationGatewayMapper userLocationMapper = UserLocationGatewayMapper.INSTANCE;

    @Override
    protected <A extends CrudRepository<UserLocationEntity, String>> A getRepository() {
        return (A) userLocationRepository;
    }

    @Override
    protected <A extends RepositoryConverter<UserLocationEntity, UserLocation>> A getRepositoryConverter() {
        return (A) userLocationMapper;
    }

    @Override
    public List<UserLocation> findByS2CellIdIn(Collection<Long> s2CellIds) {
        return userLocationRepository.findAllByS2CellIdIn(s2CellIds).stream().map(userLocationMapper::mapToEntity).toList();
    }

    @Override
    public List<UserLocation> findByS2CellIdRange(List<Long[]> coveringRanges) {
        Specification<UserLocationEntity> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (Long[] range : coveringRanges) {
                long rangeMin = range[0];
                long rangeMax = range[1];
                predicates.add(cb.between(root.get("s2CellId"), rangeMin, rangeMax));
            }
            return cb.or(predicates.toArray(new Predicate[0]));
        };

        return userLocationRepository.findAll(spec).stream()
                .map(userLocationMapper::mapToEntity)
                .toList();
    }
}










