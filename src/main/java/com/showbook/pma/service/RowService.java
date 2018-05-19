package com.showbook.pma.service;

import com.showbook.pma.model.Row;
import com.showbook.pma.repository.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowService {

    private final RowRepository rowRepository;


    @Autowired
    public RowService(RowRepository rowRepository) {
        this.rowRepository = rowRepository;

    }

    public Row findOne(Long id){ return rowRepository.findOne(id); }

    public List<Row> findAll(){
        return rowRepository.findAll();
    }

    public Row save(Row row){
        return rowRepository.save(row);
    }

    public void delete(Row row){
        rowRepository.delete(row);
    }
}
