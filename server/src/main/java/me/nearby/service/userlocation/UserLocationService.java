package me.nearby.service.userlocation;

import me.nearby.adapter.rest.userlocation.dto.NearbyQuery;
import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.userlocation.UserLocation;

import java.util.List;

public interface UserLocationService {
    List<UserLocationDTO> findNearbyUsers(NearbyQuery nearbyQuery);
    UserLocationDTO saveUserLocation(UserLocationForm userLocationForm);
}
