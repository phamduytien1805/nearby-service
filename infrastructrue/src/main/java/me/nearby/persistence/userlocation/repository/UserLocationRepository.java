package me.nearby.persistence.userlocation.repository;


import me.nearby.persistence.userlocation.UserLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserLocationRepository extends JpaRepository<UserLocationEntity, String> {
    List<UserLocationEntity> findByS2CellIdIn(Collection<Long> s2CellIds);
}
