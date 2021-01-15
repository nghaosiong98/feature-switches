package com.nghaosiong.technicalassessment.model.exception;

import java.text.MessageFormat;

public class FeatureNotFoundException extends RuntimeException{

    public FeatureNotFoundException(int id) {
        super(MessageFormat.format("Could not find feature with id: {0}", id));
    }

    public FeatureNotFoundException(String name) {
        super(MessageFormat.format("Could not find feature with name: {0}", name));
    }
}
