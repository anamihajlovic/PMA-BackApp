package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Happening {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 5)
    private String type;

    @Column(nullable = false, length = 10)
    private String genre;

    private Double duration;

    @Column(nullable = false)
    private String performers;

    private Double rating;

    private Integer numOfRatings;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "happening")
    private List<Comment> comments = new ArrayList<>();

   @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "happening")
    private List<Rating> ratings = new ArrayList<>();

   public Happening() {}

    public Happening(Long id, String name, String description, String type, String genre, Double duration,
                String performers, Double rating, Integer numOfRatings
            , List<Comment> comments, List<Rating> ratings

    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.genre = genre;
        this.duration = duration;
        this.performers = performers;
        this.rating = rating;
        this.numOfRatings = numOfRatings;
        this.comments = comments;
        this.ratings = ratings;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getGenre() {
        return genre;
    }

    public Double getDuration() {
        return duration;
    }

    public String getPerformers() {
        return performers;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getNumOfRatings() {
        return numOfRatings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setNumOfRatings(Integer numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }


}
