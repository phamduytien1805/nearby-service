package me.nearby.adapter.rest.userlocation.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLocationForm {
    private Double latitude;
    private Double longitude;
}
