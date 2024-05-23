package com.inarixdono.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record UpdateTopicDTO(@NotBlank String subject, @NotBlank String content) {

}
