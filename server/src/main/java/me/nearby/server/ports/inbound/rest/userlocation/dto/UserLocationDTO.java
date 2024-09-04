package me.nearby.server.ports.inbound.rest.userlocation.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserLocationDTO implements Serializable {
     String userId;
     Double latitude;
     Double longitude;
}
