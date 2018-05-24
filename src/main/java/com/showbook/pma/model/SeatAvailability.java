package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class SeatAvailability {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date start;

    @Column(nullable = false)
    private Date end;

    public enum Status {
        FREE,
        RESERVED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(optional = false)
    private Event event;

    @ManyToOne(optional = false)
    private Seat seat;

    @JsonIgnore
    @ManyToMany(mappedBy = "seats")
    private List<Reservation> reservations = new ArrayList<>();

    public SeatAvailability() {}

    public SeatAvailability(Long id, Date start, Date end, Status status, Event event, Seat seat, List<Reservation> reservations) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.status = status;
        this.event = event;
        this.seat = seat;
        this.reservations = reservations;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
