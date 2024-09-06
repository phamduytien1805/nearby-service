package me.nearby.userlocation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserLocation implements Serializable {
    private String userId;
    private Double latitude;
    private Double longitude;
}
