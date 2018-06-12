package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rating rating;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Event event;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "reservation_seatAvailability",
            joinColumns = { @JoinColumn(name = "reservation_id") },
            inverseJoinColumns = { @JoinColumn(name = "seat_availability_id") }
    )
    private List<SeatAvailability> seats = new ArrayList<>();


    public Reservation() {}

    public Reservation(Double totalPrice, Rating rating, User user, Event event, List<SeatAvailability> seats) {
        this.totalPrice = totalPrice;
        this.rating = rating;
        this.user = user;
        this.event = event;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<SeatAvailability> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatAvailability> seats) {
        this.seats = seats;
    }
}
