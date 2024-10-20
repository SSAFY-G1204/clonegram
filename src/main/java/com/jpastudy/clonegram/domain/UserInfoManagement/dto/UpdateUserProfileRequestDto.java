package com.jpastudy.clonegram.domain.UserInfoManagement.dto;

import lombok.Builder;

@Builder
public record UpdateUserProfileRequestDto(
        String profileImg,
        String profileCtt
) {
}
