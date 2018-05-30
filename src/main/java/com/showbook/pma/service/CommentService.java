package com.showbook.pma.service;

import com.showbook.pma.model.Comment;
import com.showbook.pma.model.Show;
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

    @Autowired
    private ShowService showService;

    @Autowired
    private UserService userService;

    public Comment findOne(Long id){
        return commentRepository.findOne(id);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment save(Comment comment){ return commentRepository.save(comment); }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }

    public Comment commentShow(Comment comment, Long showId, String username) {
        Show show = showService.findOne(showId);
        User user = userService.findByUsername(username);
        comment.setShow(show);
        comment.setUser(user);
        commentRepository.save(comment);
        return comment;
    }

    public List<Comment>getCommentsByShow (Long showId) {
        return showService.findOne(showId).getComments();
    }
}
