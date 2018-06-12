package com.showbook.pma.controller;

import com.showbook.pma.model.SeatAvailability;
import com.showbook.pma.service.SeatAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seatsAvailabilities")
public class SeatAvailabilityController {

    private final SeatAvailabilityService seatAvailabilityService;

    @Autowired
    public SeatAvailabilityController(SeatAvailabilityService seatAvailabilityService) {
        this.seatAvailabilityService = seatAvailabilityService;

    }
}
