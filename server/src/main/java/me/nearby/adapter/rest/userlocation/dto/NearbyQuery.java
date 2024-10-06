package me.nearby.adapter.rest.userlocation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NearbyQuery implements Serializable {
    Double latitude;
    Double longitude;
    Integer radius;
}
