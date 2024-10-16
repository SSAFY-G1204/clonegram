package com.jpastudy.clonegram.domain.UserInfoManagement.repository;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
