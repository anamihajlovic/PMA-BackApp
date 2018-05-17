package com.showbook.pma.service;

import com.showbook.pma.model.Repertoire;
import com.showbook.pma.repository.RepertoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepertoireService {

    @Autowired
    private RepertoireRepository repertoireRepository;

    public Repertoire findOne(Long id){
        return repertoireRepository.findOne(id);
    }

    public List<Repertoire> findAll(){
        return repertoireRepository.findAll();
    }

    public Repertoire save(Repertoire repertoire){
        return repertoireRepository.save(repertoire);
    }

    public void delete(Repertoire repertoire){
        repertoireRepository.delete(repertoire);
    }

}
