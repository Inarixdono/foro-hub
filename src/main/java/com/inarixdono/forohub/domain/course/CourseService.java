package com.inarixdono.forohub.domain.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Transactional
    public Course createCourse(IncomingCourseDTO course) {
        return repository.save(new Course(course));
    }
}
