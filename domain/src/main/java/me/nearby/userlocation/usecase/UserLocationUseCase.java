package me.nearby.userlocation.usecase;

import java.util.List;

public interface UserLocationUseCase {
    List<Long> getPossibleCellIdsNearbyLocation(Double latitude, Double longitude, double radius);
}
