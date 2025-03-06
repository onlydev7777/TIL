package com.jpatest.domain;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT l FROM Location l WHERE ST_DWithin(l.point, :referencePoint, :radiusInMeters, false) is true")
    List<Location> findLocationsWithinDistance(@Param("referencePoint") Point referencePoint,
                                               @Param("radiusInMeters") double radiusInMeters);
}
