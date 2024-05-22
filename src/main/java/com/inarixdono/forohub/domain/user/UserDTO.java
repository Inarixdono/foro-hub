package com.inarixdono.forohub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank String username, @NotBlank String password) {

}
