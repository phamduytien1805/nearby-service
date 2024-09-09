package me.nearby.adapter.datastorage.userlocation;

import me.nearby.userlocation.UserLocation;

import java.util.List;

public interface UserLocationGateway {
    UserLocation saveUserLocation(UserLocation userLocation);
}
