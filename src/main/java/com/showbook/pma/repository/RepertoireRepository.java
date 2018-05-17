package com.showbook.pma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.showbook.pma.model.Repertoire;

public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {

    @Query("select b from Repertoire b where b.id = :id")
    Repertoire findOne(@Param("id")Long id);
}