package com.showbook.pma.controller;

import com.showbook.pma.service.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rows")
public class RowController {

    private final RowService rowService;

    @Autowired
    public RowController(RowService rowService) {
        this.rowService = rowService;

    }
}
