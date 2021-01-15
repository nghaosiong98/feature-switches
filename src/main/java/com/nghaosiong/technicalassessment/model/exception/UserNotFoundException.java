package com.nghaosiong.technicalassessment.model.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String email) {
        super(MessageFormat.format("Could not find user with email: {0}", email));
    }
}
