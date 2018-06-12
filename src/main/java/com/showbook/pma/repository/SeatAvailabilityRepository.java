package com.showbook.pma.repository;

import com.showbook.pma.model.SeatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatAvailabilityRepository extends JpaRepository<SeatAvailability, Long> {

    @Query("select b from SeatAvailability b where b.id = :id")
    SeatAvailability findOne(@Param("id")Long id);
}
