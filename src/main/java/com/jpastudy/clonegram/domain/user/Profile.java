package com.jpastudy.clonegram.domain.user;

import jakarta.persistence.*;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Profile {
    @Id
    private Long userId;
    private String profileImg;
    private String profileCtt;
    @Column(nullable = false)
    private Integer followings;
    @Column(nullable = false)
    private Integer followers;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void updateProfile(String profileImg, String profileCtt){
        this.profileImg = profileImg;
        this.profileCtt = profileCtt;
    }
}
