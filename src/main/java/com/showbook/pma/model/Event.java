package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date start;

    @Column(nullable = false)
    private Date end;

    @Column(nullable = false)
    @Digits(integer = 4, fraction = 2)
    private Double price;

    @ManyToOne(optional = false)
    private Show show;

    @ManyToOne(optional = false)
    private FacilityHall facilityHall;

    @ManyToOne(optional = false)
    private Repertoire repertoire;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
    private List<SeatAvailability> seatAvailabilities = new ArrayList<>();

    public Event() {}

    public Event(Date start, Date end, Double price, Show show, FacilityHall facilityHall, Repertoire repertoire,
                 List<Reservation> reservations, List<SeatAvailability> seatAvailabilities) {
        this.start = start;
        this.end = end;
        this.price = price;
        this.show = show;
        this.facilityHall = facilityHall;
        this.repertoire = repertoire;
        this.reservations = reservations;
        this.seatAvailabilities = seatAvailabilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public FacilityHall getFacilityHall() {
        return facilityHall;
    }

    public void setFacilityHall(FacilityHall facilityHall) {
        this.facilityHall = facilityHall;
    }

    public Repertoire getRepertoire() {
        return repertoire;
    }

    public void setRepertoire(Repertoire repertoire) {
        this.repertoire = repertoire;
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
