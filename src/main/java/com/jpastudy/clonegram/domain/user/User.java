package com.jpastudy.clonegram.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private String provider;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @Builder
    public User(Long userId, String email, String password, String name, String nickname, String provider, Profile profile) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.provider = provider;
        this.profile = profile;
    }
}