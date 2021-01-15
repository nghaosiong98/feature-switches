package com.nghaosiong.technicalassessment.model.request;

import lombok.Data;

@Data
public class EnableFeatureRequest {
    private String featureName;
    private String email;
    private boolean enable;
}
