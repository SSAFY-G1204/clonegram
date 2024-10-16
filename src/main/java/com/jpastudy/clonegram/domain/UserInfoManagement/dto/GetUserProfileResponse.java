package com.jpastudy.clonegram.domain.UserInfoManagement.dto;

import lombok.Builder;

@Builder
public record GetUserProfileResponse(
        Long userId,
        String profileImg,
        String profileCtt,
        Integer followings,
        Integer followers
) {
}
