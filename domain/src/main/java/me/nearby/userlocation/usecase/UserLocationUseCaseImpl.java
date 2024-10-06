package me.nearby.userlocation.usecase;

import lombok.AllArgsConstructor;
import me.nearby.domain.geometry.usecase.GeometryUseCaseImpl;
import me.nearby.domain.geometry.usecase.RadiusConfig;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserLocationUseCaseImpl implements UserLocationUseCase {
    @Override
    public List<Long> getPossibleCellIdsNearbyLocation(Double latitude, Double longitude, RadiusConfig radiusConfig) {
        List<Long> coveringCellIds = GeometryUseCaseImpl.findAllCoveringCellIds(latitude, longitude, radiusConfig);
        return coveringCellIds;
    }
}
