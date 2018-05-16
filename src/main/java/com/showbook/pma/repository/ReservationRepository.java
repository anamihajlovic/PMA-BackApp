package com.showbook.pma.repository;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.Rating;
import com.showbook.pma.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select b from Reservation b where b.id = :id")
    public Reservation findOne(@Param("id")Long id);
}
