package me.nearby.adapter.rest.userlocation;

import lombok.AllArgsConstructor;
import me.nearby.adapter.rest.userlocation.dto.NearbyQuery;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.service.userlocation.UserLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserLocationDTO> saveUserLocation(@RequestBody UserLocationForm userLocationForm) {
        UserLocationDTO userLocation = userLocationService.saveUserLocation(UUID.fromString("c61e1ae8-7516-11ef-9986-de5277a6cb0b"), userLocationForm);
        return ResponseEntity.ok(userLocation);
    }
}
