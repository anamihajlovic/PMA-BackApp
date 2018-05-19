package com.showbook.pma.repository;

import com.showbook.pma.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("select b from Seat b where b.id = :id")
    Seat findOne(@Param("id")Long id);
}
