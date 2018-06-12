package com.showbook.pma.controller;

import com.showbook.pma.controller.dto.ReservationInfo;
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
    @RequestMapping(value = "/{username}/{facilityId}", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getUserReservationsByFacility(@PathVariable("username") String username, @PathVariable("facilityId") Long facilityId){
        return new ResponseEntity<>(reservationService.findUserReservationsByFacility(username, facilityId), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/seen/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getUserSeenShows(@PathVariable("username") String username){
        return new ResponseEntity<>(reservationService.findUserSeenShows(username), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id){
        final Reservation reservation = reservationService.findOne(id);
        reservationService.delete(reservation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/rating/{id}/{username}/{rating}", method = RequestMethod.GET)
    public ResponseEntity getUserSeenShows(@PathVariable("id") Long id,@PathVariable("username") String username,@PathVariable("rating") Integer number ){
        reservationService.rating(id,username,number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public ResponseEntity<Reservation> makeReservation(@RequestBody ReservationInfo reservationInfo){
        return new ResponseEntity<>(reservationService.makeReservation(reservationInfo), HttpStatus.OK);
    }
}
