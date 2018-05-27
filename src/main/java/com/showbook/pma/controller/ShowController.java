package com.showbook.pma.controller;

<<<<<<< HEAD
import com.showbook.pma.model.Reservation;
=======
>>>>>>> 9959616c62cf5de41710b8904b274895f6caa869
import com.showbook.pma.model.Show;
import com.showbook.pma.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private ShowService showService;

    @Autowired
    public ShowController(final ShowService showService) {
        this.showService = showService;

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Show>> getShowsByFacilitiy(@PathVariable("id") Long FacilitiyId) {
        return new ResponseEntity<>(showService.findShowsByFacility(FacilitiyId), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/interested/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Show>> getUserReservations(@PathVariable("username") String username){
        return new ResponseEntity<>(showService.findUserInterestedShows(username), HttpStatus.OK);

    }
}
