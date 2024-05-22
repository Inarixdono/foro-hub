package com.inarixdono.forohub.domain.topic;

import com.inarixdono.forohub.domain.course.CourseDTO;
import com.inarixdono.forohub.domain.user.UserDTO;

public record TopicDTO(Integer id, String subject, String content, UserDTO user, CourseDTO course) {
    public TopicDTO(Topic topic) {
        this(topic.getId(), topic.getSubject(), topic.getContent(), new UserDTO(topic.getUser()),
                new CourseDTO(topic.getCourse()));
    }
}
