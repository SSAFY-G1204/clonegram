package com.jpastudy.clonegram.domain.user;

import com.jpastudy.clonegram._core.utils.ApiUtils;
import com.jpastudy.clonegram.domain.user.dto.request.UpdateUserProfileRequest;
import com.jpastudy.clonegram.domain.user.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiUtils.ApiResult<GetUserProfileResponse>> getUserProfile(@PathVariable("userId") Long userId) {
        GetUserProfileResponse responseDTO = userService.getUserProfile(userId);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ApiUtils.ApiResult<UpdateUserProfileResponse>> updateUserProfile(@PathVariable("userId") Long userId, @RequestBody UpdateUserProfileRequest requestDTO){
        UpdateUserProfileResponse responseDTO = userService.updateUserProfile(userId, requestDTO);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

}
