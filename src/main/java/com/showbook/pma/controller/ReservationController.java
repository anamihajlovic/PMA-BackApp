package com.showbook.pma.controller;

import com.showbook.pma.model.Reservation;
import com.showbook.pma.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable("username") String username){
        return new ResponseEntity<>(reservationService.findUserReservations(username), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/seen/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getUserSeenShows(@PathVariable("username") String username){
        return new ResponseEntity<>(reservationService.findUserSeenShows(username), HttpStatus.OK);
    }
}
