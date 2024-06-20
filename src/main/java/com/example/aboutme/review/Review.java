package com.example.aboutme.review;

import com.example.aboutme.counsel.Counsel;
import com.example.aboutme.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "review_tb")
@ToString(exclude = {"user", "counsel"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 리뷰 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 리뷰 작성 유저

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counsel_id", nullable = false)
    private Counsel counsel; // 외래 키로 상담 정보를 참조

    @Column(nullable = false)
    private String content; // 리뷰 내용

    @CreationTimestamp
    private Timestamp createdAt; // 작성 시간

    @UpdateTimestamp
    private Timestamp updatedAt; // 수정 시간

    @Builder
    public Review(Integer id, User user, Counsel counsel, String content, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.user = user;
        this.counsel = counsel;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
