package com.showbook.pma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Rating rating;

    @ManyToOne(optional = false)
    private Event event;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "reservation_seat",
            joinColumns = { @JoinColumn(name = "reservation_id") },
            inverseJoinColumns = { @JoinColumn(name = "seat_id") }
    )
    private List<Seat> seats = new ArrayList<>();


    public Reservation() {}

    public Reservation(Double totalPrice, Rating rating, Event event, List<Seat> seats) {
        this.totalPrice = totalPrice;
        this.rating = rating;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
