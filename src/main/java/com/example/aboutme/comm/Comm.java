package com.example.aboutme.comm;

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
    private Integer id; // 커뮤니티 게시글 아이디

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String content; // 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 글 쓴 사람

    @OneToMany(mappedBy = "comm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reply> replies; // 댓글

    @CreationTimestamp
    private Timestamp createdAt;

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
