package com.showbook.pma.repository;

import com.showbook.pma.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select b from Event b where b.id = :id")
    Event findOne(@Param("id")Long id);
}
