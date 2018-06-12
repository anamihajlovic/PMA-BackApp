package com.showbook.pma.service;

import com.showbook.pma.model.Seat;
import com.showbook.pma.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;


    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;

    }

    public Seat findOne(Long id){ return seatRepository.findOne(id); }

    public List<Seat> findAll(){
        return seatRepository.findAll();
    }

    public Seat save(Seat seat){
        return seatRepository.save(seat);
    }

    public void delete(Seat seat){
        seatRepository.delete(seat);
    }
}
