package com.jpastudy.clonegram.domain.UserInfoManagement.repository;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
