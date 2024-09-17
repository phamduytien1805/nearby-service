package me.nearby.adapter.rest.userlocation.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class NearbyQuery implements Serializable {
    Double latitude;
    Double longitude;
    Double radius;
}
