package com.showbook.pma.controller;



import com.showbook.pma.controller.dto.MailDto;
import com.showbook.pma.controller.dto.UserCredentialsDto;
import com.showbook.pma.model.User;
import com.showbook.pma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> getUser(@RequestBody UserCredentialsDto userCredentialsDto){
        return new ResponseEntity<>(userService.findByUsername(userCredentialsDto.getUsername()), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/register/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user,@PathVariable("id") Long id_city){
        return new ResponseEntity<>(userService.registr(user, id_city), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody UserCredentialsDto userCredentialsDto) {
        return new ResponseEntity<>(userService.login(userCredentialsDto), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/changePass", method = RequestMethod.PUT)
    public ResponseEntity<User> changePass(@RequestBody  UserCredentialsDto userCredentialsDto) {
        return new ResponseEntity<>(userService.changePass(userCredentialsDto), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{username}/{location}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("username") String username, @PathVariable("location") String location){
        return new ResponseEntity<>(userService.update(user, username, location), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{username}/show/{showId}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsersForNotifications(@PathVariable("username") String username, @PathVariable("showId") Long showId){
        return new ResponseEntity<>(userService.getUsersForNotifications(username, showId), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{username}/token/{token}", method = RequestMethod.PUT)
    public ResponseEntity<User> setUserToken(@PathVariable("username") String username, @PathVariable("token") String token) {
        return new ResponseEntity<>(userService.setUserToken(username, token), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{username}/token", method = RequestMethod.PUT)
    public ResponseEntity<User> removeUserToken(@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.removeUserToken(username), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public ResponseEntity sendMail(@RequestBody MailDto mailDto) {
        userService.sendMail(mailDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
