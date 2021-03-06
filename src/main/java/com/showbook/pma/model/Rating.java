package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, length = 1)
    private Integer num;

    @ManyToOne(fetch = FetchType.EAGER)
    private Show show;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rating")
    private List<Reservation> reservations = new ArrayList<>();

    public Rating() {}

    public Rating(Long id, Integer num, Show show, List<Reservation> reservations) {
        this.id = id;
        this.num = num;
        this.show = show;
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

    public void setShow(Show show) {
        this.show = show;
    }

    public Show getShow() {
        return show;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
