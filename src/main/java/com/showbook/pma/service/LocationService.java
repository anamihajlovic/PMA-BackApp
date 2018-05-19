package com.showbook.pma.service;

import com.showbook.pma.model.Location;
import com.showbook.pma.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;


    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;

    }

    public Location findOne(Long id){ return locationRepository.findOne(id); }

    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    public Location save(Location location){
        return locationRepository.save(location);
    }

    public void delete(Location location){
        locationRepository.delete(location);
    }
}
