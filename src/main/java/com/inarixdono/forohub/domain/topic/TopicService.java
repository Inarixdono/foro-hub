package com.inarixdono.forohub.domain.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        User user = userService.getUser(topic.userId());
        Course course = courseService.findCourseById(topic.courseId());
        return repository.save(new Topic(topic, user, course));
    }

    @Transactional
    public Page<TopicDTO> listTopics(Pageable pagination) {
        return repository.findByStatusTrue(pagination).map(TopicDTO::new);
    }

    @Transactional
    public Topic geTopic(Integer id) {
        return repository.findByIdAndStatusTrue(id).orElseThrow();
    }

    @Transactional
    public Topic updateTopic(Integer id, UpdateTopicDTO updateTopicDTO) {
        Topic topic = repository.getReferenceById(id);
        topic.update(updateTopicDTO);
        return topic;
    }

    @Transactional
    public Topic deleteTopic(Integer id) {
        Topic topic = repository.getReferenceById(id);
        topic.disable();
        return topic;
    }

}
