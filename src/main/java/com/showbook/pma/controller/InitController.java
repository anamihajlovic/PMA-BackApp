package com.showbook.pma.controller;

import com.showbook.pma.model.Location;
import com.showbook.pma.model.User;
import com.showbook.pma.service.LocationService;
import com.showbook.pma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class InitController implements CommandLineRunner {


    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;

    @Override
    public void run(String... args) throws Exception {
        Location location = new Location();
        location.setName("Novi Sad");
        location.setState("Srbija");
        location.setZipCode("21000");
        locationService.save(location);

        User user1 = new User();
        user1.setFirstName("first1");
        user1.setLastName("last1");
        user1.setAddress("address1");
        user1.setLocation(location);
        user1.setUsername("user1");
        user1.setPassword("pass1");
        user1.setMaxDistance(10);
        user1.setFacilityType(User.FacilityType.CINEMA);
        userService.save(user1);

    }
}
