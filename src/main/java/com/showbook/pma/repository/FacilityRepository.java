package com.showbook.pma.repository;

import com.showbook.pma.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacilityRepository extends JpaRepository<Facility, Long>   {

    @Query("select b from Facility b where b.id = :id")
    public Facility findOne(@Param("id")Long id);
}
