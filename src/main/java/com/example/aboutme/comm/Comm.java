package com.example.aboutme.comm;

import com.example.aboutme.comm.enums.CommCategory;
import com.example.aboutme.reply.Reply;
import com.example.aboutme.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comm_tb")
@ToString(exclude = {"user", "replies"})
public class Comm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 커뮤니티 글 ID

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommCategory category; // 카테고리

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String content; // 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 글 작성 유저

    @OneToMany(mappedBy = "comm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reply> replies; // 댓글 리스트

    @CreationTimestamp
    private Timestamp createdAt; // 글 작성 시간

    @Builder
    public Comm(Integer id, String title, String content, User user, List<Reply> replies, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.replies = replies;
        this.createdAt = createdAt;
    }
}
