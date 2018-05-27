package com.showbook.pma.service;


import com.showbook.pma.model.Event;
import com.showbook.pma.model.Repertoire;
import com.showbook.pma.model.Show;
import com.showbook.pma.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private RepertoireService repertoireService;

    @Autowired
    private EventService eventService;

    public Show findOne(Long id) {
        return showRepository.findOne(id);
    }

    public List<Show> findAll() {
        return showRepository.findAll();
    }

    public Show save(Show show) {
        return showRepository.save(show);
    }

    public void delete(Show show) {
        showRepository.delete(show);
    }

    public List<Show> findShowsByFacility(Long facilltyId) {
        List<Show> result = new ArrayList<>();
        List<Repertoire> allRepertoiresForFacility = facilityService.findOne(facilltyId).getRepertoires();
        for (int i = 0; i< allRepertoiresForFacility.size();i++) {
            System.out.println("Repertoar  id je " + allRepertoiresForFacility.get(i).getId());
            if(allRepertoiresForFacility.get(i).getStart().after(new Date())){
                System.out.println("Repertoar posle danas id je " + allRepertoiresForFacility.get(i).getId());
                List<Event> foundEvents = allRepertoiresForFacility.get(i).getEvents();
                for(int m =0; m< foundEvents.size();m++) {
                    if(!result.contains(foundEvents.get(m).getShow())) {
                        System.out.println("Show je dodat a id je " + foundEvents.get(m).getShow().getId());
                        result.add(foundEvents.get(m).getShow());
                    }
                }
            }
        }
        return result;
    }
}
