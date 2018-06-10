package com.showbook.pma.repository;

import com.showbook.pma.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select b from Event b where b.id = :id")
    Event findOne(@Param("id")Long id);

    List<Event> findAllByShowAndFacilityHall_FacilityAndStartAfterAndEndBeforeOrderByStart(Show show, Facility facility, Date start, Date end);

    List<Event> findAllByShowAndFacilityHall_FacilityAndStart(Show show, Facility facility, Date start);

    Event findByShowAndFacilityHallAndStartAndRepertoire(Show show, FacilityHall facilityHall, Date start, Repertoire repertoire);

}
