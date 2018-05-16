package com.showbook.pma.service;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.User;
import com.showbook.pma.repository.CommentRepository;
import com.showbook.pma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment findOne(Long id){
        return commentRepository.findOne(id);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }
}
