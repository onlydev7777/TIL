package com.jpatest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class PostgisTest {
    @Autowired
    private LocationRepository locationRepository;

    private final GeometryFactory factory = new GeometryFactory();

    @DisplayName("postgis 데이터 save")
    @Test
    void locationSaveTest() throws Exception {
        //given
        Point point1 = factory.createPoint(new Coordinate(127.02758, 37.49794)); // 서울 강남역
        Point point2 = factory.createPoint(new Coordinate(127.03642, 37.5119));  // 서울 삼성역
        Point point3 = factory.createPoint(new Coordinate(127.10289, 37.51716)); // 서울 잠실역

        Location location1 = Location.builder().name("Gangnam Station").point(point1).build();
        Location location2 = Location.builder().name("Samseong Station").point(point2).build();
        Location location3 = Location.builder().name("Jamsil Station").point(point3).build();

        locationRepository.save(location1);
        locationRepository.save(location2);
        locationRepository.save(location3);

        // 2. Define reference point (서울 강남역) and search radius (2000 meters)
        Point referencePoint = factory.createPoint(new Coordinate(127.02758, 37.49794));
        double radiusInMeters = 2000.0;

        // 3. Query locations within 2km
        List<Location> nearbyLocations = locationRepository.findLocationsWithinDistance(referencePoint, radiusInMeters);

        // 4. Assert results
        assertThat(nearbyLocations).hasSize(2); // 강남역, 삼성역
        assertThat(nearbyLocations).extracting(Location::getName).containsExactlyInAnyOrder("Gangnam Station", "Samseong Station");
    }
}
