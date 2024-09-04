package me.nearby.server.ports.inbound.rest.userlocation;

import me.nearby.domain.userlocation.UserLocation;
import me.nearby.server.ports.inbound.rest.userlocation.dto.UserLocationDTO;
import me.nearby.spring.shared.response.MultiResponse;
import me.nearby.spring.shared.response.SingleResponse;

public interface UserLocationController {
    MultiResponse<UserLocationDTO> getNearbyUserLocations(Double latitude, Double longitude, Double radius);
    SingleResponse<UserLocationDTO> saveUserLocation(String userId, Double latitude, Double longitude);
}
