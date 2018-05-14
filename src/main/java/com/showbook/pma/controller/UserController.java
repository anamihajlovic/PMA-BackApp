package com.showbook.pma.controller;


import com.showbook.pma.model.User;
import com.showbook.pma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){

        System.out.println("Ovde je pogodilooo");
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }
}
