package com.nghaosiong.technicalassessment.model.response;

import lombok.Data;

@Data
public class CheckFeatureResponse {
    private boolean canAccess;

    public CheckFeatureResponse(boolean canAccess) {
        this.canAccess = canAccess;
    }
}
