package me.nearby.domain.geometry.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nearby.domain.geometry.usecase.exception.InvalidRadiusException;
import me.nearby.objs.EnumEntity;

@Getter
@AllArgsConstructor
public enum RadiusConfig implements EnumEntity<Integer> {
    RADIUS_10KM(10, "10km", 10, 11, 10),
    RADIUS_30KM(30, "30km", 9, 10,15),
    RADIUS_100KM(100, "100km", 8, 9, 25),
    ;

    private final Integer value;
    private final String description;
    private final Integer minLevel;
    private final Integer maxLevel;
    private final Integer maxCell;

    @Override
    public Integer getValue() {
        return this.value;
    }

    public static Integer levelToSave() {
        // Note: this value should be the largest value of maxLevel in enum
        // to ensure the correctness of the cell id range
        return 11;
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
