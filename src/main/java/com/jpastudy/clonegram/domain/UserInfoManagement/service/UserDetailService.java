package com.jpastudy.clonegram.domain.UserInfoManagement.service;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import com.jpastudy.clonegram.domain.UserInfoManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}
