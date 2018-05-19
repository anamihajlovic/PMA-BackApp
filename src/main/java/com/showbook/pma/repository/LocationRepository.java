package com.showbook.pma.repository;

import com.showbook.pma.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("select b from Location b where b.id = :id")
    public Location findOne(@Param("id")Long id);
}
