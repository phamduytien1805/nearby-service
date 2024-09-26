package me.nearby.adapter.rest.userlocation.dto;

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
public class UserLocationDTO implements Serializable {
     UUID userId;
     Double latitude;
     Double longitude;
     Double radius;
}
