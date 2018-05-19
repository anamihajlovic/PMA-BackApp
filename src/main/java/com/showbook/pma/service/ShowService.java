package com.showbook.pma.service;


import com.showbook.pma.model.Show;
import com.showbook.pma.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

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
}
