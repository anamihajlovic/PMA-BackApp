package com.showbook.pma.repository;

import com.showbook.pma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository <User, Long> {

    @Query("select b from User b where b.id = :id")
    public User findOne(@Param("id")Long id);
}
