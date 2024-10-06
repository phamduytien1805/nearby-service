package me.nearby.domain.geometry.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nearby.domain.geometry.usecase.exception.InvalidRadiusException;
import me.nearby.objs.EnumEntity;

@Getter
@AllArgsConstructor
public enum RadiusConfig implements EnumEntity<Integer> {
    RADIUS_5KM(5, "5km", 10, 11),
    RADIUS_15KM(15, "15km", 9, 10),
    RADIUS_30KM(30, "30km", 8, 9),
    RADIUS_50KM(50, "50km", 7, 8),
    RADIUS_100KM(100, "100km", 6, 7),
    ;

    private final Integer value;
    private final String description;
    private final Integer minLevel;
    private final Integer maxLevel;

    @Override
    public Integer getValue() {
        return this.value;
    }

    public static RadiusConfig findByValue(Integer value) {
        for (RadiusConfig element : RadiusConfig.values()) {
            if (element.getValue().equals(value)) {
                return element;
            }
        }
        throw new InvalidRadiusException("Invalid radius value: " + value);
    }
}
