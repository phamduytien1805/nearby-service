package me.nearby.userlocation.usecase;

import me.nearby.userlocation.UserLocation;

import java.util.List;

public interface UserLocationUseCase {
    List<Long> getPossibleCellIdsNearbyUsers(UserLocation userLocation, double radius);
}
