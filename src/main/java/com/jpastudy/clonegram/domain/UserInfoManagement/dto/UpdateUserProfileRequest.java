package com.jpastudy.clonegram.domain.UserInfoManagement.dto;

import lombok.Builder;

@Builder
public record UpdateUserProfileRequest(
        String profileImg,
        String profileCtt
) {
}
