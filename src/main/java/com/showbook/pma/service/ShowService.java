package com.showbook.pma.service;


import com.showbook.pma.model.*;
import com.showbook.pma.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private FacilityService facilityService;

    public Show findOne(Long id) {
        return showRepository.findOne(id);
    }

    public List<Show> findAll() {
        return showRepository.findAll();
    }

    public Show save(Show show) {
        return showRepository.save(show);
    }

    public void delete(Show show) {
        showRepository.delete(show);
    }


    public List<Show> findShowsByFacility(Long facilltyId) {
        List<Show> result = new ArrayList<>();
        List<Repertoire> allRepertoiresForFacility = facilityService.findOne(facilltyId).getRepertoires();
        for (int i = 0; i < allRepertoiresForFacility.size(); i++) {
            System.out.println("Repertoar  id je " + allRepertoiresForFacility.get(i).getId());
            if (allRepertoiresForFacility.get(i).getEnd().after(new Date())) {
                System.out.println("Repertoar posle danas id je " + allRepertoiresForFacility.get(i).getId());
                List<Event> foundEvents = allRepertoiresForFacility.get(i).getEvents();
                for (int m = 0; m < foundEvents.size(); m++) {
                    if (!result.contains(foundEvents.get(m).getShow())) {
                        System.out.println("Show je dodat a id je " + foundEvents.get(m).getShow().getId());
                        result.add(foundEvents.get(m).getShow());
                    }
                }
            }
        }
        return result;
    }
    public List<Show> findUserInterestedShows(String username) {
        User user = userService.findByUsername(username);
        if(user != null) {
            return showRepository.findAllByUsers(user);
        }
        return null;
    }

    public List<Show> findUserInterestedShowsByFacility(String username, Long facilityId) {
        User user = userService.findByUsername(username);
        Facility facility = facilityService.findOne(facilityId);
        List<Show> result = new ArrayList<>();

        if (user != null && facility != null) {
            List<Show> facilityShows = findShowsByFacility(facilityId);
            List<Show> shows = showRepository.findDistinctByUsersAndEvents_FacilityHall_Facility(user, facility);
            for (Show show : shows) {
                if (facilityShows.contains(show) && !result.contains(show)) {
                    result.add(show);
                }
            }
        }
        return result;
    }



    public Boolean isInterestedShow(String username, Long showId) {
        User user = userService.findByUsername(username);
        Show show = showRepository.findOne(showId);
        if (user != null && show != null) {
            List<Show> shows = showRepository.findAllByUsers(user);
            return shows.contains(show);
        }
        return null;
    }

    public Show addToInterested(String username, Long showId) {
        User user = userService.findByUsername(username);
        Show show = showRepository.findOne(showId);
        show.getUsers().add(user);
        return showRepository.save(show);
    }

    public Show removeFromInterested(String username, Long showId) {
        User user = userService.findByUsername(username);
        Show show = showRepository.findOne(showId);
        show.getUsers().remove(user);
        return showRepository.save(show);
    }
}
