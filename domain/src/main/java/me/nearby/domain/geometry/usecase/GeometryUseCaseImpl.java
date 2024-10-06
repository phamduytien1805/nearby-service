package me.nearby.domain.geometry.usecase;

import com.google.common.geometry.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GeometryUseCaseImpl{
    public static double getRadiusMeters() {
        return 6371010.0;
    }

    /** Returns the Earth's mean radius as above, but in kilometers. */
    public static double getRadiusKm() {
        return 0.001 * getRadiusMeters();
    }

    /** Converts the given kilometers to radians. */
    public static double kmToRadians(double km) {
        return km / getRadiusKm();
    }

    public static List<Long> findAllCoveringCellIds(double latitude, double longitude, RadiusConfig radiusConfig) {
        // Step 1: Convert latitude/longitude to S2LatLng and then to S2Point
        S2LatLng latLng = S2LatLng.fromDegrees(latitude, longitude);
        S2Point point = latLng.toPoint();  // Convert to an S2Point (3D representation on a sphere)

        // Step 2: Create an S2Cap to represent the circular region with the given radius
        S2Cap cap = S2Cap.fromAxisAngle(point, S1Angle.radians(kmToRadians(radiusConfig.getValue())));  // Create the S2Cap using the angle

        // Step 3: Define how the region should be covered (by cells)
        S2RegionCoverer.Builder covererBuilder = S2RegionCoverer.builder();

        covererBuilder.setMinLevel(radiusConfig.getMinLevel());
        covererBuilder.setMaxLevel(radiusConfig.getMaxLevel());

        // Step 4: Create the covering from the spherical cap
        S2RegionCoverer coverer = covererBuilder.build();

        // Step 5: Get the list of S2 cell IDs (unique identifiers for the covering cells)
        return coverer.getCovering(cap).cellIds().stream()
                .map(S2CellId::id)  // Convert the S2 cells to their ID representation
                .collect(Collectors.toList());
    }

    public static Long getCellId(double latitude, double longitude, RadiusConfig radiusConfig) {
        S2LatLng latLng = S2LatLng.fromDegrees(latitude, longitude);
        S2CellId cellId = S2CellId.fromLatLng(latLng).parent(radiusConfig.getMinLevel());
        return cellId.id();
    }
}
