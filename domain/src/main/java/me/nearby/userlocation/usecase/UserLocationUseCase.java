package me.nearby.userlocation.usecase;

import me.nearby.domain.geometry.usecase.RadiusConfig;

import java.util.List;

public interface UserLocationUseCase {
    List<Long> getPossibleCellIdsNearbyLocation(Double latitude, Double longitude, RadiusConfig radius);
}
