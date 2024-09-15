package me.nearby.adapter.rest.userlocation;

import lombok.AllArgsConstructor;
import me.nearby.adapter.rest.userlocation.mapper.UserLocationDTOMapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.service.userlocation.UserLocationService;
import me.nearby.spring.shared.response.MultiResponse;
import me.nearby.spring.shared.response.SingleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/user-location"})
@AllArgsConstructor
public class UserLocationController {
    private final UserLocationService userLocationService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserLocationDTO>> getNearbyUserLocations(Double latitude, Double longitude, Double radius) {
        List<UserLocationDTO> userLocationList = userLocationService.findNearbyUsers(latitude, longitude, radius);
        return ResponseEntity.ok(userLocationList);
    }

    public SingleResponse<UserLocationDTO> saveUserLocation(String userId, Double latitude, Double longitude) {
        return null;
    }
}
