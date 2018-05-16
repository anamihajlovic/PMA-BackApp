package com.showbook.pma.service;

import com.showbook.pma.model.Rating;
import com.showbook.pma.model.Reservation;
import com.showbook.pma.repository.RatingRepository;
import com.showbook.pma.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findOne(Long id){
        return reservationRepository.findOne(id);
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationRepository.delete(reservation);
    }
}
