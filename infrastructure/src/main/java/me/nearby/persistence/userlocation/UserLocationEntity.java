package me.nearby.persistence.userlocation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity(name = "user_location")
public class UserLocationEntity implements Serializable {
    @Id
    @GeneratedValue
    UUID id;
    UUID userId;
    Double latitude;
    Double longitude;
    Long s2CellId;
}
