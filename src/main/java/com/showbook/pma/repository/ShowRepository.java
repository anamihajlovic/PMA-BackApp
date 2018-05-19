package com.showbook.pma.repository;

import com.showbook.pma.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowRepository extends JpaRepository<Show, Long>   {

    @Query("select b from Show b where b.id = :id")
    public Show findOne(@Param("id")Long id);
}
