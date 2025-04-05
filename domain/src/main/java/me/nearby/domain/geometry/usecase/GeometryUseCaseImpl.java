package me.nearby.domain.geometry.usecase;

import com.google.common.geometry.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GeometryUseCaseImpl{
    /** Returns the Earth's mean radius as above, but in kilometers. */
    public static double getRadiusKm() {
        return 6371.01;
    }

    /** Converts the given kilometers to radians. */
    public static double kmToRadians(double km) {
        return km / getRadiusKm();
    }

    public static List<Long[]> findAllCoveringCellIds(double latitude, double longitude, RadiusConfig radiusConfig) {
        // Step 1: Convert latitude/longitude to S2LatLng and then to S2Point
        S2LatLng latLng = S2LatLng.fromDegrees(latitude, longitude);
        double angleRad = kmToRadians(radiusConfig.getValue());

        // Step 2: Create an S2Cap to represent the circular region with the given radius
        S2Cap cap = S2Cap.fromAxisAngle(latLng.toPoint(), S1Angle.radians(angleRad));// Create the S2Cap using the angle

        // Step 3: Define how the region should be covered (by cells)
        S2RegionCoverer coverer = S2RegionCoverer.builder().setMinLevel(radiusConfig.getMaxLevel()).setMaxLevel(radiusConfig.getMaxLevel()).setMaxCells(radiusConfig.getMaxCell()).build();

        List<Long[]> ranges = new ArrayList<>();
        for (S2CellId cellId : coverer.getCovering(cap)) {
            long rangeMin = cellId.rangeMin().id();
            long rangeMax = cellId.rangeMax().id();
            ranges.add(new Long[]{rangeMin, rangeMax});
        }
        return ranges;
    }

    public static Long getCellId(double latitude, double longitude) {
        S2LatLng latLng = S2LatLng.fromDegrees(latitude, longitude);
        S2CellId cellId = S2CellId.fromLatLng(latLng).parent(RadiusConfig.levelToSave());
        return cellId.id();
    }
}
