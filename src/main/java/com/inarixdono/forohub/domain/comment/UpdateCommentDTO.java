package com.inarixdono.forohub.domain.comment;

import jakarta.validation.constraints.NotBlank;

public record UpdateCommentDTO(@NotBlank String content) {

}
