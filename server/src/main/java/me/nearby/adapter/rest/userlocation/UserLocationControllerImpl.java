package me.nearby.adapter.rest.userlocation;

import lombok.AllArgsConstructor;
import me.nearby.adapter.rest.userlocation.mapper.UserLocationDTOMapper;

import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.spring.shared.response.MultiResponse;
import me.nearby.spring.shared.response.SingleResponse;
import me.nearby.userlocation.UserLocation;
import me.nearby.userlocation.usecase.UserLocationUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"/api/user-location", "/api/website/article"})
@AllArgsConstructor
public class UserLocationControllerImpl {
    private final UserLocationUseCase userLocationUseCase;
    private final UserLocationDTOMapper userLocationDTOMapper = UserLocationDTOMapper.BUILDER;

    public MultiResponse<UserLocationDTO> getNearbyUserLocations(Double latitude, Double longitude, Double radius) {
        List<UserLocation> userLocationList = userLocationUseCase.findNearbyUsers(latitude, longitude, radius);
        return MultiResponse.of(userLocationList.stream().map(userLocationDTOMapper::mapToDTO).collect(Collectors.toList()));
    }

    public SingleResponse<UserLocationDTO> saveUserLocation(String userId, Double latitude, Double longitude) {
        return null;
    }
}
