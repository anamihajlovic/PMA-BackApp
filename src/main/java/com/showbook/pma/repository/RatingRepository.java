package com.showbook.pma.repository;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long>   {

    @Query("select b from Rating b where b.id = :id")
    public Rating findOne(@Param("id")Long id);


}
