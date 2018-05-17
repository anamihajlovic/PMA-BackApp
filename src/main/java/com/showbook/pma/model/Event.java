package com.showbook.pma.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date start;

    @Column(nullable = false)
    private Date end;

    @Column(nullable = false)
    @Digits(integer = 4, fraction = 2)
    private Double price;

    @ManyToOne
    private Happening happening;

    @ManyToOne
    private FacilityHall facilityHall;

    public Event() {}

    public Event(Date start, Date end, Double price, Happening happening, FacilityHall facilityHall) {
        this.start = start;
        this.end = end;
        this.price = price;
        this.happening = happening;
        this.facilityHall = facilityHall;
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

    public Happening getHappening() {
        return happening;
    }

    public void setHappening(Happening happening) {
        this.happening = happening;
    }

    public FacilityHall getFacilityHall() {
        return facilityHall;
    }

    public void setFacilityHall(FacilityHall facilityHall) {
        this.facilityHall = facilityHall;
    }
}
