package me.nearby.persistence.userlocation.repository;


import me.nearby.persistence.userlocation.UserLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocationEntity, String> {
}
