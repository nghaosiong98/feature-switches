package com.nghaosiong.technicalassessment.service;

import com.nghaosiong.technicalassessment.model.entity.UserAccess;
import com.nghaosiong.technicalassessment.model.exception.UserAccessNotFoundException;
import com.nghaosiong.technicalassessment.repository.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccessService {
    @Autowired
    UserAccessRepository userAccessRepository;

    public UserAccess getUserAccessByUserIdAndFeatureId(int userId, int featureId) {
        return userAccessRepository.findUserAccessByUserIdAndFeatureId(userId, featureId).orElseThrow(() ->
                new UserAccessNotFoundException(userId, featureId));
    }

    public void saveOrUpdate(UserAccess userAccess) {
        userAccessRepository.save(userAccess);
    }
}

