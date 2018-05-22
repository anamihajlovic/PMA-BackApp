package com.showbook.pma.service;

import com.showbook.pma.controller.dto.UserCredentialsDto;
import com.showbook.pma.model.User;
import com.showbook.pma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOne(Long id){
        return userRepository.findOne(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User login(UserCredentialsDto userCredentialsDto) {
        return userRepository.findByUsernameAndPassword(userCredentialsDto.getUsername(), userCredentialsDto.getPassword());
    }

    public User changePass(UserCredentialsDto user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        return userRepository.save(foundUser);
    }

}
