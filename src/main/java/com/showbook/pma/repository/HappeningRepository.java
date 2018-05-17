package com.showbook.pma.repository;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.Happening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HappeningRepository extends JpaRepository<Happening, Long>   {

    @Query("select b from Happening b where b.id = :id")
    public Happening findOne(@Param("id")Long id);
}
