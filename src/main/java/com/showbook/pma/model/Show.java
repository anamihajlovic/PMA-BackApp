package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[show]")
public class Show {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public enum Type {
        MOVIE,
        PLAY
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false, length = 50)
    private String genre;

    @Column(nullable = false)
    private Double duration;

    private String performers;

    @Column(nullable = false)
    private String directors;

    private Double rating;

    private Integer numOfRatings;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "show")
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "show")
    private List<Rating> ratings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "show")
    private List<Event> events = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_interestedShow",
            joinColumns = { @JoinColumn(name = "show_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> users = new ArrayList<>();

    public Show() {
    }

    public Show(String name, String description, Type type, String genre, Double duration, String performers, String directors,
                Double rating, Integer numOfRatings, List<Comment> comments, List<Rating> ratings, List<Event> events, List<User> users) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.genre = genre;
        this.duration = duration;
        this.performers = performers;
        this.directors =directors;
        this.rating = rating;
        this.numOfRatings = numOfRatings;
        this.comments = comments;
        this.ratings = ratings;
        this.events = events;
        this.users = users;
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }
}
