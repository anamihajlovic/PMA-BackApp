package com.showbook.pma.repository;

import com.showbook.pma.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RowRepository extends JpaRepository<Row, Long> {

    @Query("select b from Row b where b.id = :id")
    Row findOne(@Param("id")Long id);
}
