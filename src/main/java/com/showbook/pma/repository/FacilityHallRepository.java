package com.showbook.pma.repository;

import com.showbook.pma.model.FacilityHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacilityHallRepository extends JpaRepository<FacilityHall, Long>   {

    @Query("select b from FacilityHall b where b.id = :id")
    FacilityHall findOne(@Param("id")Long id);

    List<FacilityHall> findByFacilityId(Long facilityId);

}
