package com.showbook.pma.controller;

import com.showbook.pma.service.RepertoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/repertoires")
public class RepertoireController {

    private RepertoireService repertoireService;

    @Autowired
    public RepertoireController(final RepertoireService repertoireService) {
        this.repertoireService = repertoireService;

    }
}
