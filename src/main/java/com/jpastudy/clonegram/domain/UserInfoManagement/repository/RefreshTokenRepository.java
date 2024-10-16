package com.jpastudy.clonegram.domain.UserInfoManagement.repository;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long userId);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
