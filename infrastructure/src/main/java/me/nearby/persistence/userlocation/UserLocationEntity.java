package me.nearby.persistence.userlocation;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_locations")
@Data
public class UserLocationEntity implements Serializable {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id",insertable = false, updatable = false, nullable = false)
    UUID id;

    UUID userId;
    Double latitude;
    Double longitude;
    Long s2CellId;
}
