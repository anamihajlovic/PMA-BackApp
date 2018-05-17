package com.showbook.pma.controller;

import com.showbook.pma.service.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shows")
public class HappeningController {

    private HappeningService happeningService;

    @Autowired
    public HappeningController(final HappeningService happeningService) {
        this.happeningService = happeningService;

    }
}
