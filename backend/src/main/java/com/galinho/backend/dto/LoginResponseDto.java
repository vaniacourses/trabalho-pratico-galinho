package com.galinho.backend.dto;

import com.galinho.backend.utils.Role;

public record LoginResponseDto(Long id,
                               Role role) {
}
