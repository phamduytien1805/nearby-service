package me.nearby.persistence.userlocation.repository;


import me.nearby.persistence.userlocation.UserLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;

public interface UserLocationRepository extends JpaRepository<UserLocationEntity, String>, JpaSpecificationExecutor<UserLocationEntity> {
    List<UserLocationEntity> findAllByS2CellIdIn(Collection<Long> s2CellIds);
}
