package com.jpastudy.clonegram.domain.ContentManagement.repository;

import com.jpastudy.clonegram.domain.ContentManagement.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserUserId(Long userId);

}