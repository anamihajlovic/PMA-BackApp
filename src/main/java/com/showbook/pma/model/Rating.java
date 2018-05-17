package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 1)
    private Integer num;

    @ManyToOne(fetch = FetchType.EAGER)
    private Happening happening;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rating")
    private List<Reservation> reservations = new ArrayList<>();

    public Rating() {}

    public Rating(Long id, Integer num, Happening happening, List<Reservation> reservations) {
        this.id = id;
        this.num = num;
        this.happening = happening;
        this.reservations = reservations;
    }


    public Long getId() {
        return id;
    }

    public Integer getNum() {
        return num;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setHappening(Happening happening) {
        this.happening = happening;
    }

    public Happening getHappening() {
        return happening;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
