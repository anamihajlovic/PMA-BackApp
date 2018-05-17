package com.showbook.pma.model;

import javax.persistence.*;

@Entity
public class Facility {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private String descritpion;

    public enum Type {
        CINEMA,
        THEATER
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Facility.Type type;

    @Column(nullable = false)
    private String address;

//    @ManyToOne
//    private Location location;


    public Facility() {}

    public Facility(String name, String descritpion, Type type, String address) {
        this.name = name;
        this.descritpion = descritpion;
        this.type = type;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
