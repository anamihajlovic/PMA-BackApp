package com.showbook.pma.service;

import com.showbook.pma.model.*;
import com.showbook.pma.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private FacilityHallService facilityHallService;

    @Autowired
    private RepertoireService repertoireService;

    public Event findOne(Long id){
        return eventRepository.findOne(id);
    }

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Event save(Event event){
        return eventRepository.save(event);
    }

    public void delete(Event event){
        eventRepository.delete(event);
    }

    public List<String> findEventTimes(Long showId, Long facilityId, String dateString) {
        Show show = showService.findOne(showId);
        Facility facility = facilityService.findOne(facilityId);

        List<String> times = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");


        try {
            Date startDate = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, 1);
            if(show != null && facility != null) {
                List<Event> events =  eventRepository.findAllByShowAndFacilityHall_FacilityAndStartAfterAndEndBeforeOrderByStart(show, facility, startDate, calendar.getTime());
                for(Event event : events) {
                    times.add(timeFormat.format(event.getStart().getTime()));
                }
                return times;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<String> findEventHalls(Long showId, Long facilityId, String dateString, String timeString) {
        Show show = showService.findOne(showId);
        Facility facility = facilityService.findOne(facilityId);

        List<String> halls = new ArrayList<>();
        String dateTimeString = dateString + " " + timeString;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        try {
            Date dateTime = sdf.parse(dateTimeString);
            if(show != null && facility != null) {
                List<Event> events = eventRepository.findAllByShowAndFacilityHall_FacilityAndStart(show, facility, dateTime);
                for(Event event : events) {
                    halls.add(event.getFacilityHall().getName());
                }
                return halls;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SeatAvailability> findEventSeats(Long showId, Long facilityId, String facilityHallName, String dateString, String timeString) {
        Show show = showService.findOne(showId);
        Facility facility = facilityService.findOne(facilityId);
        FacilityHall facilityHall = facilityHallService.findByFacilityAndName(facility, facilityHallName);

        List<SeatAvailability> seats = new ArrayList<>();
        String dateTimeString = dateString + " " + timeString;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        try {
            Date dateTime = sdf.parse(dateTimeString);
            Repertoire repertoire = repertoireService.findRepertoireByFacilityAndDate(facility, dateTime);
            if(show != null && facilityHall != null && repertoire != null) {
               Event event = eventRepository.findByShowAndFacilityHallAndStartAndRepertoire(show, facilityHall, dateTime, repertoire);
                for(SeatAvailability sa : event.getSeatAvailabilities()) {
                    seats.add(sa);
                }
                return seats;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }





}
