package me.nearby.domain.geometry.usecase;

import java.util.List;

public interface GeometryUseCase {
    List<Long> findAllCoveringCellIds(double latitude, double longitude, double radiusKm);
}
