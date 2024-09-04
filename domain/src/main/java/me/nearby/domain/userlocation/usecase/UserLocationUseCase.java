package me.nearby.domain.userlocation.usecase;

import me.nearby.domain.userlocation.UserLocation;

import java.util.List;

public interface UserLocationUseCase {
    UserLocation saveUserLocation(String userId, Double latitude, Double longitude);
    List<UserLocation> findNearbyUsers(Double latitude, Double longitude, Double radius);
}
