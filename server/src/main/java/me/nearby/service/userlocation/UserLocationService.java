package me.nearby.service.userlocation;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.userlocation.UserLocation;

import java.util.List;

public interface UserLocationService {
    List<UserLocationDTO> findNearbyUsers(Double latitude, Double longitude, Double radius);
}
