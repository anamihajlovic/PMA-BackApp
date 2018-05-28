package com.showbook.pma.controller;


import com.showbook.pma.model.Reservation;

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
    public ResponseEntity<List<Show>> getUserInterestedShows(@PathVariable("username") String username){
        return new ResponseEntity<>(showService.findUserInterestedShows(username), HttpStatus.OK);

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/interested/{username}/{showId}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isInterestedShow(@PathVariable("username") String username, @PathVariable("showId") Long showId){
        return new ResponseEntity<>(showService.isInterestedShow(username, showId), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/interested/add/{username}/{showId}", method = RequestMethod.POST)
    public ResponseEntity<Show> addToInterested(@PathVariable("username") String username, @PathVariable("showId") Long showId){
        return new ResponseEntity<>(showService.addToInterested(username, showId), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/interested/remove/{username}/{showId}", method = RequestMethod.POST)
    public ResponseEntity<Show> removeFromInterested(@PathVariable("username") String username, @PathVariable("showId") Long showId){
        return new ResponseEntity<>(showService.removeFromInterested(username, showId), HttpStatus.OK);
    }
}
