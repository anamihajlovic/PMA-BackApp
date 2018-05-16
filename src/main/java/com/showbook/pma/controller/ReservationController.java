package com.showbook.pma.controller;

import com.showbook.pma.service.RatingService;
import com.showbook.pma.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;

    }
}
