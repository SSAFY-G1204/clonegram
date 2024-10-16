package com.jpastudy.clonegram.domain.UserInteractions.dao;

import com.jpastudy.clonegram.domain.ContentManagement.dao.Post;
import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@Table(name = "likes")
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;

}
