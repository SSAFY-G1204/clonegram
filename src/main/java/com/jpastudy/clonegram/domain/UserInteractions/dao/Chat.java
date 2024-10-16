package com.jpastudy.clonegram.domain.UserInteractions.dao;

import com.jpastudy.clonegram.domain.UserInfoManagement.dao.User;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ChannelId;
    @Column(nullable = false)
    private Long receivedId;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

}
