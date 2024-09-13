package me.nearby.domain.geometry.usecase;

import com.google.common.geometry.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GeometryUseCaseImpl implements GeometryUseCase{
    /**
     * The number 6371 is the approximate radius of the Earth in kilometers.
     * In the context of the S2 geometry library, when you want to define a spherical cap (a circular region on the surface of the Earth)
     * for a given radius in kilometers, you need to convert that radius from kilometers
     * to a corresponding angular distance (an angle measured in radians).
     */
    private final Double earthRadiusKm = 6371.0;

    private static final NavigableMap<Double, Integer> RADIUS_TO_CELLS;

    static {
        // Initialize the map with radius thresholds and corresponding cell counts
        RADIUS_TO_CELLS = new TreeMap<>();
        RADIUS_TO_CELLS.put(1.0, 20);  // <= 1 km radius
        RADIUS_TO_CELLS.put(5.0, 10);  // <= 5 km radius
        RADIUS_TO_CELLS.put(10.0, 8);  // <= 10 km radius
        RADIUS_TO_CELLS.put(Double.MAX_VALUE, 6);  // > 10 km radius
    }

    @Override
    public List<Long> findAllCoveringCellIds(double latitude, double longitude, double radiusKm) {
        // Step 1: Convert latitude/longitude to S2LatLng and then to S2Point
        S2LatLng latLng = S2LatLng.fromDegrees(latitude, longitude);
        S2Point point = latLng.toPoint(); //Convert to an S2Point (3D representation on a sphere)

        // Step 2: Create an S2Cap to represent the circular region with the given radius
        S2Cap cap = S2Cap.fromAxisAngle(point, S1Angle.radians(radiusKm / earthRadiusKm)); // Earth's radius in kilometers

        // Step 3: Define how the region should be covered (by cells)
        S2RegionCoverer.Builder covererBuilder = S2RegionCoverer.builder();
        covererBuilder.setMaxCells(RADIUS_TO_CELLS.ceilingEntry(radiusKm).getValue()); // Limit the number of cells in the covering

        // Create the covering from the spherical cap
        S2RegionCoverer coverer = covererBuilder.build();

        // Step 5: Get the list of S2 cell IDs (unique identifiers for the covering cells)
        return coverer.getCovering(cap).cellIds().stream()
                .map(S2CellId::id)  // Convert the S2 cells to their ID representation
                .collect(Collectors.toList());
    }
}
