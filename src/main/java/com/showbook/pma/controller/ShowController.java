package com.showbook.pma.controller;

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
    @RequestMapping(value = "/interested/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Show>> getUserReservations(@PathVariable("username") String username){
        return new ResponseEntity<>(showService.findUserInterestedShows(username), HttpStatus.OK);
    }
}
