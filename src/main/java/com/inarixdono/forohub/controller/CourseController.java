package com.inarixdono.forohub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inarixdono.forohub.domain.course.CourseDTO;
import com.inarixdono.forohub.domain.course.CourseService;
import com.inarixdono.forohub.domain.course.IncomingCourseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody @Valid IncomingCourseDTO course, UriComponentsBuilder builder) {
        CourseDTO courseDTO = new CourseDTO(service.createCourse(course));
        URI uri = UriBuilder.buildForId(builder, "/courses/{id}", courseDTO.id().toString());
        return ResponseEntity.created(uri).body(courseDTO);
    }

}
