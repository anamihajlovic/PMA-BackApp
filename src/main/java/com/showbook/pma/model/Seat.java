package com.showbook.pma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @ManyToMany(mappedBy = "seats")
    private List<Reservation> reservations = new ArrayList<>();

    public Seat() {}

    public Seat(Long id, Integer number, List<Reservation> reservations) {
        this.id = id;
        this.number = number;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}

