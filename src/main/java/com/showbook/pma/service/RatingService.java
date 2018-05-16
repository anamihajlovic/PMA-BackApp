package com.showbook.pma.service;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.Rating;
import com.showbook.pma.repository.CommentRepository;
import com.showbook.pma.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating findOne(Long id){
        return ratingRepository.findOne(id);
    }

    public List<Rating> findAll(){
        return ratingRepository.findAll();
    }

    public Rating save(Rating rating){
        return ratingRepository.save(rating);
    }

    public void delete(Rating rating){
        ratingRepository.delete(rating);
    }
}
