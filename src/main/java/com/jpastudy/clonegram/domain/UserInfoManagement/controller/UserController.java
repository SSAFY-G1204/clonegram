package com.jpastudy.clonegram.domain.UserInfoManagement.controller;

import com.jpastudy.clonegram._core.utils.ApiUtils;
import com.jpastudy.clonegram.domain.UserInfoManagement.dto.GetUserProfileResponseDto;
import com.jpastudy.clonegram.domain.UserInfoManagement.dto.UpdateUserProfileResponseDto;
import com.jpastudy.clonegram.domain.UserInfoManagement.service.UserService;
import com.jpastudy.clonegram.domain.UserInfoManagement.dto.UpdateUserProfileRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiUtils.ApiResult<GetUserProfileResponseDto>> getUserProfile(@PathVariable("userId") Long userId) {
        GetUserProfileResponseDto responseDTO = userService.getUserProfile(userId);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ApiUtils.ApiResult<UpdateUserProfileResponseDto>> updateUserProfile(@PathVariable("userId") Long userId, @RequestBody UpdateUserProfileRequestDto requestDTO){
        UpdateUserProfileResponseDto responseDTO = userService.updateUserProfile(userId, requestDTO);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

}
