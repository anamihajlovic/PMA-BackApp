package com.showbook.pma.service;

import com.showbook.pma.model.FacilityHall;
import com.showbook.pma.repository.FacilityHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityHallService {

    @Autowired
    private FacilityHallRepository facilityHallRepository;

    public FacilityHall findOne(Long id){
        return facilityHallRepository.findOne(id);
    }

    public List<FacilityHall> findAll(){
        return facilityHallRepository.findAll();
    }

    public FacilityHall save(FacilityHall facilityHall){
        return facilityHallRepository.save(facilityHall);
    }

    public void delete(FacilityHall facilityHall){
        facilityHallRepository.delete(facilityHall);
    }

}