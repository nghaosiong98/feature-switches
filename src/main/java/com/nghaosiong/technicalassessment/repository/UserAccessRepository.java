package com.nghaosiong.technicalassessment.repository;

import com.nghaosiong.technicalassessment.model.entity.UserAccess;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserAccessRepository extends CrudRepository<UserAccess, Integer> {
    @Query(
            value = "SELECT * FROM user_access WHERE user_id = :user_id AND feature_id = :feature_id",
            nativeQuery = true
    )
    Optional<UserAccess> findUserAccessByUserIdAndFeatureId(
            @Param("user_id") int userId,
            @Param("feature_id") int featureId
    );
}
