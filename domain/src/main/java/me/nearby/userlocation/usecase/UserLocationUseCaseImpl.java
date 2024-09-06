package me.nearby.userlocation.usecase;

import me.nearby.userlocation.UserLocation;

import java.util.List;

public class UserLocationUseCaseImpl implements UserLocationUseCase {
    @Override
    public UserLocation saveUserLocation(String userId, Double latitude, Double longitude) {
        return null;
    }

    @Override
    public List<UserLocation> findNearbyUsers(Double latitude, Double longitude, Double radius) {
        return null;
    }
}
