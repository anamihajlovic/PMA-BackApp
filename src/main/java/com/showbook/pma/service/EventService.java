package com.showbook.pma.service;

import com.showbook.pma.model.Event;
import com.showbook.pma.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event findOne(Long id){
        return eventRepository.findOne(id);
    }

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Event save(Event event){
        return eventRepository.save(event);
    }

    public void delete(Event event){
        eventRepository.delete(event);
    }
}
