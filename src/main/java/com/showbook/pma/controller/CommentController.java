package com.showbook.pma.controller;


import com.showbook.pma.model.Comment;
import com.showbook.pma.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(final CommentService commentService) {
        this.commentService = commentService;

    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{showId}/{username}", method = RequestMethod.POST)
    public ResponseEntity<Comment> commentShow(@RequestBody Comment comment, @PathVariable("showId") Long showId,
                                            @PathVariable("username") String username){
        return new ResponseEntity<>(commentService.commentShow(comment, showId, username), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{showId}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getCommentsByShow(@PathVariable("showId") Long showId){
        return new ResponseEntity<>(commentService.getCommentsByShow(showId), HttpStatus.OK);
    }


}
