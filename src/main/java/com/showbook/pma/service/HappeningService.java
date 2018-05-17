package com.showbook.pma.service;


import com.showbook.pma.model.Happening;
import com.showbook.pma.repository.HappeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HappeningService {

    @Autowired
    private HappeningRepository happeningRepository;

    public Happening findOne(Long id){
        return happeningRepository.findOne(id);
    }

    public List<Happening> findAll(){
        return happeningRepository.findAll();
    }

    public Happening save(Happening show){
        return happeningRepository.save(show);
    }

    public void delete(Happening show){
        happeningRepository.delete(show);
    }
}
