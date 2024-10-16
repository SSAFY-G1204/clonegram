package com.jpastudy.clonegram.domain.ContentManagement.dao;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import com.jpastudy.clonegram.domain.UserInteractions.dao.Comment;
import com.jpastudy.clonegram.domain.UserInteractions.dao.Like;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId ;

    //내용
    @Column(length = 100)
    private String content;

    //좋아요 수
    @Column(length = 100, nullable = false)
    private String liking;

    //등록일
    @Column(nullable = false)
    private String rgtDate;

    //유저키
    @OneToMany(mappedBy ="post")
    @Column(nullable = false)
    private List<Like> likes = new ArrayList<Like>();

    @OneToMany(mappedBy ="post")
    @Column(nullable = false)
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "post")
    @Column(nullable=false)
    private List<Media> medias = new ArrayList<Media>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
