package com.inarixdono.forohub.domain.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inarixdono.forohub.domain.course.Course;
import com.inarixdono.forohub.domain.course.CourseService;
import com.inarixdono.forohub.domain.user.User;
import com.inarixdono.forohub.domain.user.UserService;

import jakarta.transaction.Transactional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Transactional
    public Topic createTopic(IncomingTopicDTO topic) {
        User user = userService.findUserById(topic.userId());
        Course course = courseService.findCourseById(topic.courseId());
        return repository.save(new Topic(topic, user, course));
    }

}
