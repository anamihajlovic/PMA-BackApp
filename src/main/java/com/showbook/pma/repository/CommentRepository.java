package com.showbook.pma.repository;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository  extends JpaRepository<Comment, Long> {

    @Query("select b from Comment b where b.id = :id")
    public Comment findOne(@Param("id")Long id);

}
