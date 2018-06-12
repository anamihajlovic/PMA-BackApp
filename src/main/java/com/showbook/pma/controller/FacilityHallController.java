package com.showbook.pma.controller;

import com.showbook.pma.service.FacilityHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facilityHalls")
public class FacilityHallController {

    private FacilityHallService facilityHallService;

    @Autowired
    public FacilityHallController(final FacilityHallService facilityHallService) {
        this.facilityHallService = facilityHallService;

    }
}
