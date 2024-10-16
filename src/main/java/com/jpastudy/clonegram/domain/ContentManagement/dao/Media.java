package com.jpastudy.clonegram.domain.ContentManagement.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@Table(name = "medias")
public class Media {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "postId")  // 외래 키로 profiles 테이블에서 userId를 사용합니다.
    private Post post;

    @Column
    private String imageSrc;

}