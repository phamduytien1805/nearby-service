package me.nearby.persistence.userlocation;

import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "user_location")
@Data
public class UserLocationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String userId;
    Double latitude;
    Double longitude;
}
