package com.showbook.pma.service;

import com.showbook.pma.model.Reservation;
import com.showbook.pma.model.User;
import com.showbook.pma.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserService userService;

    public Reservation findOne(Long id){
        return reservationRepository.findOne(id);
    }

    public List<Reservation> findAll() {return reservationRepository.findAll(); }

    public List<Reservation> findUserReservations(String username) {
        User user = userService.findByUsername(username);
        List<Reservation> all = reservationRepository.findAllByUser(user);

        List<Reservation> reservations = new ArrayList<>();
        Date currentDate = new Date();
        for (Reservation res: all) {
            if (res.getEvent().getStart().compareTo(currentDate) >= 0) {
                reservations.add(res);
            }
        }
        return reservations;
    }

    public List<Reservation> findUserSeenShows(String username) {
        User user = userService.findByUsername(username);
        List<Reservation> reservations = reservationRepository.findAllByUser(user);

        List<Reservation> seenShows = new ArrayList<>();
        Date currentDate = new Date();
        for (Reservation reservation : reservations) {
            if (reservation.getEvent().getEnd().compareTo(currentDate) < 0) {
                seenShows.add(reservation);
            }
        }
        return seenShows;
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationRepository.delete(reservation);
    }
}
