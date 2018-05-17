package com.showbook.pma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "facility")
    private List<FacilityHall> facilityHalls = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "facility")
    private List<Repertoire> repertoires = new ArrayList<>();

    public Facility() {}

    public Facility(String name, String descritpion, Type type, String address, List<FacilityHall> facilityHalls, List<Repertoire> repertoires) {
        this.name = name;
        this.descritpion = descritpion;
        this.type = type;
        this.address = address;
        this.facilityHalls = facilityHalls;
        this.repertoires = repertoires;
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

    public List<FacilityHall> getFacilityHalls() {
        return facilityHalls;
    }

    public void setFacilityHalls(List<FacilityHall> facilityHalls) {
        this.facilityHalls = facilityHalls;
    }

    public List<Repertoire> getRepertoires() {
        return repertoires;
    }

    public void setRepertoires(List<Repertoire> repertoires) {
        this.repertoires = repertoires;
    }
}
