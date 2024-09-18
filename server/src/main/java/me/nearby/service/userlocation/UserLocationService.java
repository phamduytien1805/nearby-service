package me.nearby.service.userlocation;

import me.nearby.adapter.rest.userlocation.dto.NearbyQuery;
import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.userlocation.UserLocation;

import java.util.List;
import java.util.UUID;

public interface UserLocationService {
    List<UserLocationDTO> findNearbyUsers(NearbyQuery nearbyQuery);
    UserLocationDTO saveUserLocation(UUID uuid,UserLocationForm userLocationForm);
}
