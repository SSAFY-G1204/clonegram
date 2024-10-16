package com.jpastudy.clonegram.domain.UserInteractions.dao;

import com.jpastudy.clonegram.domain.ContentManagement.dao.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Date rgtDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postId")
    private Post post;
}
