package com.showbook.pma.controller;

import com.showbook.pma.service.CommentService;
import com.showbook.pma.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController(final RatingService ratingService) {
        this.ratingService = ratingService;

    }
}
