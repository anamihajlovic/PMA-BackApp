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

    @ManyToOne(optional = false)
    private Row row;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "seat")
    private List<SeatAvailability> seatAvailabilities = new ArrayList<>();

    @ManyToMany(mappedBy = "seats")
    private List<Reservation> reservations = new ArrayList<>();

    public Seat() {}

    public Seat(Long id, Integer number, Row row, List<Reservation> reservations, List<SeatAvailability> seatAvailabilities) {
        this.id = id;
        this.number = number;
        this.row  = row;
        this.reservations = reservations;
        this.seatAvailabilities = seatAvailabilities;
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

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<SeatAvailability> getSeatAvailabilities() {
        return seatAvailabilities;
    }

    public void setSeatAvailabilities(List<SeatAvailability> seatAvailabilities) {
        this.seatAvailabilities = seatAvailabilities;
    }
}

