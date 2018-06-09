package com.showbook.pma.controller;

import com.showbook.pma.model.SeatAvailability;
import com.showbook.pma.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{showId}/{facilityId}/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getEventTimes(@PathVariable("showId") Long showId, @PathVariable("facilityId") Long facilityId, @PathVariable("date") String date ){
        return new ResponseEntity<>(eventService.findEventTimes(showId, facilityId, date), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{showId}/{facilityId}/{date}/{time}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getEventHalls(@PathVariable("showId") Long showId, @PathVariable("facilityId") Long facilityId, @PathVariable("date") String date, @PathVariable("time") String time){
        return new ResponseEntity<>(eventService.findEventHalls(showId, facilityId, date, time), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{showId}/{facilityId}/{facilityHallName}/{date}/{time}", method = RequestMethod.GET)
    public ResponseEntity<List<SeatAvailability>> getEventSeats(@PathVariable("showId") Long showId, @PathVariable("facilityId") Long facilityId, @PathVariable("facilityHallName") String facilityHallName, @PathVariable("date") String date, @PathVariable("time") String time){
        return new ResponseEntity<>(eventService.findEventSeats(showId, facilityId, facilityHallName, date, time), HttpStatus.OK);
    }
}
