package com.showbook.pma.controller;

import com.showbook.pma.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private FacilityService facilityService;

    @Autowired
    public FacilityController(final FacilityService facilityService) {
        this.facilityService = facilityService;

    }
}
