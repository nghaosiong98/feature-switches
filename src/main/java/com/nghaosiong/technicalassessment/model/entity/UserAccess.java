package com.nghaosiong.technicalassessment.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private int feature_id;
    private boolean has_access;

    public UserAccess() {
    }

    public UserAccess(int user_id, int feature_id, boolean has_access) {
        this.user_id = user_id;
        this.feature_id = feature_id;
        this.has_access = has_access;
    }

}
