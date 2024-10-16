package com.jpastudy.clonegram.domain.SocialRelations.dao;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@Table(name = "relations")
public class Relation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;

    //팔로잉을 하는 사람
    @ManyToOne
    @JoinColumn(name = "userId")
    private User users;

    //팔로우를 하는 사람
    private Long followerId;

}