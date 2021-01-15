package com.nghaosiong.technicalassessment.repository;

import com.nghaosiong.technicalassessment.model.entity.Feature;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FeatureRepository extends CrudRepository<Feature, Integer> {
    @Query(
            name = "SELECT * FROM feature WHERE name = :name",
            nativeQuery = true
    )

    Optional<Feature> findFeatureByName(@Param("name") String name);
}
