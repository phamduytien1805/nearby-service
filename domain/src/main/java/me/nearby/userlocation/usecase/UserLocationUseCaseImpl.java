package me.nearby.userlocation.usecase;

import lombok.AllArgsConstructor;
import me.nearby.domain.geometry.usecase.GeometryUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserLocationUseCaseImpl implements UserLocationUseCase {
    private GeometryUseCase geometryUseCase;
    @Override
    public List<Long> getPossibleCellIdsNearbyLocation(Double latitude, Double longitude, double radius) {
        List<Long> coveringCellIds = geometryUseCase.findAllCoveringCellIds(latitude, longitude, radius);
        return coveringCellIds;
    }

}
