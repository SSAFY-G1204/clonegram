package com.jpastudy.clonegram.domain.user;

import com.jpastudy.clonegram._core.errors.exception.Exception400;
import com.jpastudy.clonegram.domain.user.dto.request.UpdateUserProfileRequest;
import com.jpastudy.clonegram.domain.user.dto.response.GetUserProfileResponse;
import com.jpastudy.clonegram.domain.user.dto.response.UpdateUserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final ProfileRepository profileRepository;
    public GetUserProfileResponse getUserProfile(Long userId){
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new Exception400("프로필을 찾을 수 없습니다")
        );

        return GetUserProfileResponse.builder()
                .userId(profile.getUserId())
                .profileImg(profile.getProfileImg())
                .profileCtt(profile.getProfileCtt())
                .followings(profile.getFollowings())
                .followers(profile.getFollowers())
                .build();
    }

    @Transactional
    public UpdateUserProfileResponse updateUserProfile(Long userId, UpdateUserProfileRequest requestDTO){
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new Exception400("프로필을 찾을 수 없습니다")
        );

        profile.updateProfile(requestDTO.profileImg(), requestDTO.profileCtt());

        return UpdateUserProfileResponse.builder().response("프로필 업데이트를 완료하였습니다.").build();
    }
}