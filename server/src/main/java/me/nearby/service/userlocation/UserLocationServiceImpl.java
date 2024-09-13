package me.nearby.service.userlocation;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import me.nearby.adapter.datastorage.userlocation.UserLocationGateway;
import me.nearby.userlocation.UserLocation;
import me.nearby.userlocation.usecase.UserLocationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLocationServiceImpl implements UserLocationService {
    @Resource
    private final UserLocationUseCase userLocationUseCase;

    @Resource
    private final UserLocationGateway userLocationGateway;

    @Override
    public List<UserLocation> findNearbyUsers(UserLocation userLocation, double radius) {
        return null;
    }
}
