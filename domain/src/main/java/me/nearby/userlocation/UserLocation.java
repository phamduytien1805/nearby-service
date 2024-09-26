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
    UUID id;
    UUID userId;
    Double latitude;
    Double longitude;
    Long s2CellId;
}
