package com.showbook.pma.service;


import com.showbook.pma.controller.dto.MailDto;
import com.showbook.pma.controller.dto.UserCredentialsDto;
import com.showbook.pma.model.Location;
import com.showbook.pma.model.Show;
import com.showbook.pma.model.User;
import com.showbook.pma.repository.LocationRepository;
import com.showbook.pma.repository.ShowRepository;
import com.showbook.pma.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private JavaMailSender javaMailSender;


    public User findOne(Long id){
        return userRepository.findOne(id);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User login(UserCredentialsDto userCredentialsDto) {
        return userRepository.findByUsernameAndPassword(userCredentialsDto.getUsername(), userCredentialsDto.getPassword());
    }

    public User registr (User user, Long id_city) {
        if(userRepository.findByUsername(user.getUsername()) == null){
            user.setFacilityType(User.FacilityType.ALL);
            Location location = locationRepository.findOne(id_city);
            user.setLocation(location);
            user.setMaxDistance(10);
            user.setCommentNotification(true);
            return userRepository.save(user);
        }else {
            return null;
        }

    }

    public User changePass(UserCredentialsDto user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        return userRepository.save(foundUser);
    }

    public User update(User user, String username, String location) {
        User dbUser = userRepository.findByUsername(username);
        Location dbLocation = locationRepository.findByName(location);

        if (dbUser != null && dbLocation != null) {
            dbUser.setFirstName(user.getFirstName());
            dbUser.setLastName(user.getLastName());
            dbUser.setAddress(user.getAddress());
            dbUser.setLocation(dbLocation);
            return userRepository.save(dbUser);
        }
        return null;

    }

    public List<User> getUsersForNotifications(String username, Long showId) {
        User user = userRepository.findByUsername(username);
        Show show = showRepository.findOne(showId);
        List<User> users = new ArrayList<>();

        for (User u: show.getUsers()) {
            if (!u.getId().equals(user.getId()))
                users.add(u);

        }

        return users;
    }

    public User setUserToken(String username, String token) {
        User dbUser = userRepository.findByUsername(username);
        dbUser.setToken(token);
        return userRepository.save(dbUser);
    }

    public User removeUserToken(String username) {
        User dbUser = userRepository.findByUsername(username);
        dbUser.setToken(null);
        return userRepository.save(dbUser);
    }

    public void sendMail(MailDto mailDto){
        System.out.println(mailDto.getTo());
        System.out.println(mailDto.getSubject());
        System.out.println(mailDto.getText());
        System.out.println(mailDto.getCommentUser());
        try {
            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setFrom("showbookpma@gmail.com");
            mail.setTo(mailDto.getTo());
            mail.setSubject(mailDto.getSubject());
            mail.setText(mailDto.getCommentUser() + " " + mailDto.getText() + "Pogledajte komentar u aplikaciji ShowBook.");

            javaMailSender.send(mail);

        } catch (Exception e) {
            System.out.println("Greska prilikom slanja mail-a.");
        }


    }


}
