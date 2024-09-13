package me.nearby.userlocation.usecase;

import lombok.AllArgsConstructor;
import me.nearby.domain.geometry.usecase.GeometryUseCase;
import me.nearby.userlocation.UserLocation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserLocationUseCaseImpl implements UserLocationUseCase {
    private final GeometryUseCase geometryUseCase;
    @Override
    public List<Long> getPossibleCellIdsNearbyUsers(UserLocation userLocation, double radius) {
        return null;
    }

}
