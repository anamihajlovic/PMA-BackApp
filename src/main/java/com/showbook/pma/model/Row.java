package com.showbook.pma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[row]")
public class Row {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne(optional = false)
    private FacilityHall facilityHall;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "row")
    private List<Seat> seats = new ArrayList<>();

    public Row() {}

    public Row(Long id, Integer number, FacilityHall facilityHall, List<Seat> seats) {
        this.id = id;
        this.number = number;
        this.facilityHall = facilityHall;
        this.seats = seats;
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

    public FacilityHall getFacilityHall() {
        return facilityHall;
    }

    public void setFacilityHall(FacilityHall facilityHall) {
        this.facilityHall = facilityHall;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
