package com.showbook.pma.controller.dto;

import java.util.List;

public class ReservationInfo {

    private String username;
    private Long eventId;
    private List<Long> selectedSeats;

    public ReservationInfo() {
    }

    public ReservationInfo(String username, Long eventId, List<Long> selectedSeats) {
        this.username = username;
        this.eventId = eventId;
        this.selectedSeats = selectedSeats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public List<Long> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<Long> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
}


