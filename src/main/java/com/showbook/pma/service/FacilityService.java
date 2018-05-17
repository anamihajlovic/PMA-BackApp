package com.showbook.pma.service;

import com.showbook.pma.model.Facility;
import com.showbook.pma.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    public Facility findOne(Long id){
        return facilityRepository.findOne(id);
    }

    public List<Facility> findAll(){
        return facilityRepository.findAll();
    }

    public Facility save(Facility facility){
        return facilityRepository.save(facility);
    }

    public void delete(Facility facility){
        facilityRepository.delete(facility);
    }
}
