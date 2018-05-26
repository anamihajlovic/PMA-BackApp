package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public enum Type {
        CINEMA,
        THEATER
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Facility.Type type;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String  latitude;

    @Column(nullable = false)
    private String  longitude;

    @ManyToOne(optional = false)
    private Location location;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "facility")
    private List<FacilityHall> facilityHalls = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "facility")
    private List<Repertoire> repertoires = new ArrayList<>();

    public Facility() {}

    public Facility(Long id, String address, String name,Facility.Type type , String latitude, String longitude, Location location, List<FacilityHall> facilityHalls, List<Repertoire> repertoires) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
