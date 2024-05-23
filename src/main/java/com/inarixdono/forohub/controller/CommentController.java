package com.inarixdono.forohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import com.inarixdono.forohub.domain.comment.CommentDTO;
import com.inarixdono.forohub.domain.comment.CommentService;
import com.inarixdono.forohub.domain.comment.IncommingCommentDTO;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody IncommingCommentDTO commentDTO, UriComponentsBuilder builder) {
        CommentDTO comment = new CommentDTO(service.createComment(commentDTO));
        URI uri = UriBuilder.buildForId(builder, "/comments/{id}", comment.id().toString());
        return ResponseEntity.created(uri).body(comment);
    }
}
