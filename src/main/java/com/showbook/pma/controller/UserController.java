package com.showbook.pma.controller;


import com.showbook.pma.controller.dto.UserCredentialsDto;
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

        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> getUser(@RequestBody String username){
        System.out.println(userService.findByUsername(username));
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/registr/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> getUser(@RequestBody User user,@PathVariable("id") Long id_city){
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
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
    }
}
