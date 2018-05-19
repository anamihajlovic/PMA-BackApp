package com.showbook.pma.service;

import com.showbook.pma.model.SeatAvailability;
import com.showbook.pma.repository.SeatAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatAvailabilityService {

    private final SeatAvailabilityRepository seatAvailabilityRepository;


    @Autowired
    public SeatAvailabilityService(SeatAvailabilityRepository seatAvailabilityRepository) {
        this.seatAvailabilityRepository = seatAvailabilityRepository;

    }

    public SeatAvailability findOne(Long id){ return seatAvailabilityRepository.findOne(id); }

    public List<SeatAvailability> findAll(){
        return seatAvailabilityRepository.findAll();
    }

    public SeatAvailability save(SeatAvailability seatAvailability){ return seatAvailabilityRepository.save(seatAvailability); }

    public void delete(SeatAvailability seatAvailability){
        seatAvailabilityRepository.delete(seatAvailability);
    }
}
