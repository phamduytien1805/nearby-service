package me.nearby.userlocation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserLocation implements Serializable {
    private UUID id;
    private String userId;
    private Double latitude;
    private Double longitude;
    private Long s2CellId;
}
