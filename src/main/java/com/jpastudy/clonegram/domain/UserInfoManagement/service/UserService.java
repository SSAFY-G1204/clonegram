package com.jpastudy.clonegram.domain.UserInfoManagement.service;

import com.jpastudy.clonegram._core.errors.exception.Exception400;
import com.jpastudy.clonegram.domain.UserInfoManagement.dao.Profile;
import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import com.jpastudy.clonegram.domain.UserInfoManagement.dto.UpdateUserProfileRequestDto;
import com.jpastudy.clonegram.domain.UserInfoManagement.dto.GetUserProfileResponseDto;
import com.jpastudy.clonegram.domain.UserInfoManagement.dto.UpdateUserProfileResponseDto;
import com.jpastudy.clonegram.domain.UserInfoManagement.repository.ProfileRepository;
import com.jpastudy.clonegram.domain.UserInfoManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public GetUserProfileResponseDto getUserProfile(Long userId){
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new Exception400("프로필을 찾을 수 없습니다")
        );

        return GetUserProfileResponseDto.builder()
                .userId(profile.getUserId())
                .profileImg(profile.getProfileImg())
                .profileCtt(profile.getProfileCtt())
                .followings(profile.getFollowings())
                .followers(profile.getFollowers())
                .build();
    }

    @Transactional
    public UpdateUserProfileResponseDto updateUserProfile(Long userId, UpdateUserProfileRequestDto requestDTO){
        Profile profile = profileRepository.findById(userId).orElseThrow(
                () -> new Exception400("프로필을 찾을 수 없습니다")
        );

        profile.updateProfile(requestDTO.profileImg(), requestDTO.profileCtt());

        return UpdateUserProfileResponseDto.builder().message("프로필 업데이트를 완료하였습니다.").build();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
