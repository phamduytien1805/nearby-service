package me.nearby.service.userlocation;

import me.nearby.userlocation.UserLocation;

import java.util.List;

public interface UserLocationService {
    List<UserLocation> findNearbyUsers(UserLocation userLocation, double radius);
}
