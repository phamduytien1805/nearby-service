package me.nearby.service.userlocation;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import me.nearby.adapter.datastorage.userlocation.UserLocationGateway;
import me.nearby.adapter.rest.userlocation.dto.UserLocationDTO;
import me.nearby.adapter.rest.userlocation.mapper.UserLocationDTOMapper;
import me.nearby.userlocation.UserLocation;
import me.nearby.userlocation.usecase.UserLocationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<UserLocationDTO> findNearbyUsers(Double latitude, Double longitude, Double radius) {
        List<Long> coveringCellIds = userLocationUseCase.getPossibleCellIdsNearbyLocation(latitude,longitude , radius);
        return userLocationGateway.findByS2CellIdIn(coveringCellIds).stream().map(userLocationDTOMapper::mapToDTO).collect(Collectors.toList());
    }
}
