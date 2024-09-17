package me.nearby.service.userlocation;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import me.nearby.adapter.datastorage.userlocation.UserLocationGateway;
import me.nearby.adapter.rest.userlocation.dto.NearbyQuery;
import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.adapter.rest.userlocation.dto.UserLocationForm;
import me.nearby.adapter.rest.userlocation.mapper.UserLocationDTOMapper;
import me.nearby.userlocation.UserLocation;
import me.nearby.userlocation.usecase.UserLocationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserLocationServiceImpl implements UserLocationService {
    @Resource
    private final UserLocationUseCase userLocationUseCase;

    @Resource
    private final UserLocationGateway userLocationGateway;

    @Resource
    private final UserLocationDTOMapper userLocationDTOMapper = UserLocationDTOMapper.BUILDER;


    @Override
    public List<UserLocationDTO> findNearbyUsers(NearbyQuery nearbyQuery) {
        List<Long> coveringCellIds = userLocationUseCase.getPossibleCellIdsNearbyLocation(nearbyQuery.getLatitude(),nearbyQuery.getLongitude() ,nearbyQuery.getRadius());
        return userLocationGateway.findByS2CellIdIn(coveringCellIds).stream().map(userLocationDTOMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserLocationDTO saveUserLocation(UUID userId, UserLocationForm userLocationForm) {
        UserLocation userLocation = userLocationGateway.save();
        return userLocationDTOMapper.mapToDTO(userLocation);
    }
}
