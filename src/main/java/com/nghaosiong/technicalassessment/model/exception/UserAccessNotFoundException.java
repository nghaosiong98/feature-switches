package com.nghaosiong.technicalassessment.model.exception;

import java.text.MessageFormat;

public class UserAccessNotFoundException extends RuntimeException {

    public UserAccessNotFoundException(String email, String featureName) {
        super(MessageFormat.format(
                "Cannot find user access with email: {0} and feature: {1}",
                email,
                featureName
        ));
    }

    public UserAccessNotFoundException(int userId, int featureId) {
        super(MessageFormat.format(
                "Cannot find user access with user id: {0} and feature id: {1}",
                userId,
                featureId
        ));
    }
}
