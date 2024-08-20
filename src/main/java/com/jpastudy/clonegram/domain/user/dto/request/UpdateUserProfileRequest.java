package com.jpastudy.clonegram.domain.user.dto.request;

import lombok.Builder;

@Builder
public record UpdateUserProfileRequest(
        String profileImg,
        String profileCtt
) {
}
