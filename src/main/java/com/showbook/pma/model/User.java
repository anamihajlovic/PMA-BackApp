package com.showbook.pma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,  length = 40)
    private String firstName;

    @Column(nullable = false,  length = 80)
    private String lastName;

    @Column(nullable = false, unique = true,  length = 60)
    private String username;

    @Column(nullable = false,  length = 60)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column
    private Integer maxDistance;

    public enum FacilityType {
        ALL,
        CINEMA,
        THEATER
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FacilityType facilityType;

    @ManyToOne(optional = true)
    private Location location;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_interestedShow",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "show_id") },
            uniqueConstraints = @UniqueConstraint(columnNames={"user_id", "show_id"})
    )
    private List<Show> interestedShows = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public  User() {}

    public User(Long id, String firstName, String lastName, String username, String password, String address, Integer maxDistance,
                FacilityType facilityType, Location location, List<Reservation> reservations, List<Show> interestedShows,
                List<Comment> comments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.maxDistance = maxDistance;
        this.facilityType = facilityType;
        this.location = location;
        this.reservations = reservations;
        this.interestedShows = interestedShows;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Show> getInterestedShows() {
        return interestedShows;
    }

    public void setInterestedShows(List<Show> interestedShows) {
        this.interestedShows = interestedShows;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
