package com.showbook.pma.service;


import com.showbook.pma.model.Show;
import com.showbook.pma.model.User;
import com.showbook.pma.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserService userService;

    public Show findOne(Long id){
        return showRepository.findOne(id);
    }

    public List<Show> findAll(){
        return showRepository.findAll();
    }

    public Show save(Show show){
        return showRepository.save(show);
    }

    public void delete(Show show){
        showRepository.delete(show);
    }

    public List<Show> findUserInterestedShows(String username) {
        User user = userService.findByUsername(username);
        if(user != null) {
            return showRepository.findAllByUsers(user);
        }
        return null;
    }

    public Boolean isInterestedShow(String username, Long showId) {
        User user = userService.findByUsername(username);
        Show show = showRepository.findOne(showId);
        if (user != null && show != null) {
            List<Show> shows = showRepository.findAllByUsers(user);
            return shows.contains(show);
        }
        return null;
    }

    public Show addToInterested(String username, Long showId) {
        User user = userService.findByUsername(username);
        Show show = showRepository.findOne(showId);
        show.getUsers().add(user);
        return showRepository.save(show);
    }

    public Show removeFromInterested(String username, Long showId) {
        User user = userService.findByUsername(username);
        Show show = showRepository.findOne(showId);
        show.getUsers().remove(user);
        return showRepository.save(show);
    }
}
