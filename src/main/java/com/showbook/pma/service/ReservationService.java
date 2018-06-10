package com.showbook.pma.service;

import com.showbook.pma.model.*;
import com.showbook.pma.repository.RatingRepository;
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
    private RatingRepository ratingRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private UserService userService;

    @Autowired
    private FacilityService facilityService;

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
            if (res.getEvent().getStart().compareTo(currentDate) > 0) {
                reservations.add(res);
            }
        }
        return reservations;
    }

    public List<Reservation> findUserReservationsByFacility(String username, Long facilityId) {
        User user = userService.findByUsername(username);
        Facility facility = facilityService.findOne(facilityId);
        if(user != null && facility != null) {
            List<Reservation> allReservations = reservationRepository.findAllByUserAndEvent_FacilityHall_Facility(user, facility);
            List<Reservation> reservations = new ArrayList<>();
            Date currentDate = new Date();
            for (Reservation reservation: allReservations) {
                if (reservation.getEvent().getStart().compareTo(currentDate) > 0) {
                    reservations.add(reservation);
                }
            }
            return reservations;
        }
        return null;
    }


    public List<Reservation> findUserSeenShows(String username) {
        User user = userService.findByUsername(username);
        List<Reservation> reservations = reservationRepository.findAllByUser(user);

        List<Reservation> seenShows = new ArrayList<>();
        Date currentDate = new Date();
        for (int i = 0; i< reservations.size() ;i ++) {
            if (reservations.get(i).getEvent().getEnd().before(currentDate)) {
                seenShows.add(reservations.get(i));
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

    public void rating(Long id, String username, Integer num ) {
        Reservation reservation = reservationRepository.findOne(id);
        User user = userService.findByUsername(username);
        System.out.println("reserva je " + reservation.getRating());

        if (reservation.getRating() == null) {
            System.out.println("uslo u prvo ");
            Rating rating = new Rating();
            rating.setNum(num);
            rating.setShow(reservation.getEvent().getShow());
            ratingRepository.save(rating);
            Show show = reservation.getEvent().getShow();
            if (show.getRating() != null) {
                Double newRating = (show.getRating() + num) / 2;
                show.setRating(newRating);
                showService.save(show);

            } else {

                show.setRating(Double.parseDouble(num.toString()));
                showService.save(show);
            }
            reservation.setRating(rating);
            reservationRepository.save(reservation);

        } else {
            System.out.println("uslo u drugo ");
            Rating rating = ratingRepository.findOne(reservation.getRating().getId());
            Integer oldNum = rating.getNum();
            rating.setNum(num);
            ratingRepository.save(rating);
            Show show = reservation.getEvent().getShow();
            Double newRating = (((show.getRating()*2)-oldNum) + num) / 2;
            show.setRating(newRating);
            showService.save(show);

        }
    }
}
