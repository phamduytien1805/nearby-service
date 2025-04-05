package me.nearby.adapter.datastorage.userlocation;

import me.nearby.spring.repository.RepositoryGateway;
import me.nearby.userlocation.UserLocation;

import java.util.Collection;
import java.util.List;

public interface UserLocationGateway extends RepositoryGateway<UserLocation, String> {
    List<UserLocation> findByS2CellIdIn(Collection<Long> s2CellIds);
    List<UserLocation> findByS2CellIdRange(List<Long[]> coveringRanges);
}
