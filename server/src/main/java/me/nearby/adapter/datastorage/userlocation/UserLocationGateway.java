package me.nearby.adapter.datastorage.userlocation;

import me.nearby.userlocation.UserLocation;

import java.util.List;

public interface UserLocationGateway {
    UserLocation saveUserLocation(String userId, Double latitude, Double longitude);
    List<UserLocation> findNearbyUsers(Double latitude, Double longitude, Double radius);
}
