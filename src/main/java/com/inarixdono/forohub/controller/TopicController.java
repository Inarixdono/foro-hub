package com.inarixdono.forohub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inarixdono.forohub.domain.topic.IncomingTopicDTO;
import com.inarixdono.forohub.domain.topic.TopicDTO;
import com.inarixdono.forohub.domain.topic.TopicService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody @Valid IncomingTopicDTO topic, UriComponentsBuilder builder) {
        TopicDTO topicDTO = new TopicDTO(service.createTopic(topic));
        URI uri = UriBuilder.buildForId(builder, "/topics/{id}", topicDTO.id().toString());
        return ResponseEntity.created(uri).body(topicDTO);
    }
}
