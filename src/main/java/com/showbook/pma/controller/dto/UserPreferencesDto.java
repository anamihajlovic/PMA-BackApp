package com.showbook.pma.controller.dto;

import com.showbook.pma.model.User;

public class UserPreferencesDto {

    private Integer maxDistance;
    private Boolean commentNotification;
    private User.FacilityType facilityType;

    public UserPreferencesDto() {}

    public UserPreferencesDto(Integer maxDistance, Boolean commentNotification, User.FacilityType facilityType) {
        this.maxDistance = maxDistance;
        this.commentNotification = commentNotification;
        this.facilityType = facilityType;
    }


    public Integer getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Boolean getCommentNotification() {
        return commentNotification;
    }

    public void setCommentNotification(Boolean commentNotification) {
        this.commentNotification = commentNotification;
    }

    public User.FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(User.FacilityType facilityType) {
        this.facilityType = facilityType;
    }
}
