package me.nearby.adapter.rest.userlocation;

import lombok.AllArgsConstructor;
import me.nearby.adapter.rest.userlocation.dto.NearbyQuery;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.adapter.rest.userlocation.mapper.UserLocationDTOMapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.service.userlocation.UserLocationService;
import me.nearby.spring.shared.response.MultiResponse;
import me.nearby.spring.shared.response.SingleResponse;
import me.nearby.userlocation.UserLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/user-location"})
@AllArgsConstructor
public class UserLocationController {
    private final UserLocationService userLocationService;


    @PostMapping(value = "/search-nearby")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserLocationDTO>> getNearbyUserLocations(@RequestBody NearbyQuery nearbyQuery) {
        List<UserLocationDTO> userLocationList = userLocationService.findNearbyUsers(nearbyQuery);
        return ResponseEntity.ok(userLocationList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SingleResponse<UserLocationDTO> saveUserLocation(@RequestBody UserLocationForm userLocationForm) {
        UserLocation userLocation = userLocationService.saveUserLocation(-1, latitude, longitude);
        return null;
    }
}
