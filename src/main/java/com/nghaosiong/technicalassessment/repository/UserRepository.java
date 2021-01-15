package com.nghaosiong.technicalassessment.repository;

import com.nghaosiong.technicalassessment.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(
            value = "SELECT * FROM user WHERE email = :email",
            nativeQuery = true
    )
    Optional<User> findUserByEmail(@Param("email") String email);
}
