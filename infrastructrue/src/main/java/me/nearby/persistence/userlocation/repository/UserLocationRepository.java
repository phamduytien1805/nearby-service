package me.nearby.persistence.userlocation.repository;


import me.nearby.persistence.userlocation.UserLocationEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserLocationRepository extends CassandraRepository<UserLocationEntity, String> {
}
