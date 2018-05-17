package com.showbook.pma.model;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Rating rating;

    public Reservation() {}

    public Reservation(Long id, Double totalPrice, Rating rating) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.rating = rating;
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
}
