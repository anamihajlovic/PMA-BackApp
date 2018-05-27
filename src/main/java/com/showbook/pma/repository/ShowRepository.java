package com.showbook.pma.repository;

import com.showbook.pma.model.Show;
import com.showbook.pma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long>   {

    @Query("select b from Show b where b.id = :id")
    Show findOne(@Param("id")Long id);

    List<Show> findAllByUsers(User user);

}
