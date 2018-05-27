package com.showbook.pma.controller;

import com.showbook.pma.model.Facility;
import com.showbook.pma.model.User;
import com.showbook.pma.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private FacilityService facilityService;

    @Autowired
    public FacilityController(final FacilityService facilityService) {
        this.facilityService = facilityService;

    }

    @CrossOrigin(origins="*")
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Facility>> getAllFacilities(){
        return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
    }
}
