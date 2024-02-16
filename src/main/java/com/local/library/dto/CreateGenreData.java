package com.local.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateGenreData(@NotBlank
                              @Size(max = 250)
                              String name) {
}
