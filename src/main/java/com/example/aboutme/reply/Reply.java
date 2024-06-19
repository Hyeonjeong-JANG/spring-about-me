package com.example.aboutme.reply;

import com.example.aboutme.comm.Comm;
import com.example.aboutme.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reply_tb")
@ToString(exclude = {"user", "comm"})
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 댓글 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 글쓴이

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comm_id", nullable = false)
    private Comm comm; // 게시글

    // expert 댓글일 경우(summary, causeAnalysis, solution)
    @Column(nullable = false)
    private String summary; // AI 요약

    @Column(nullable = false)
    private String causeAnalysis; // 원인 분석

    @Column(nullable = false)
    private String solution; // 해결책

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Reply(Integer id, User user, Comm comm, String summary, String causeAnalysis, String solution, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.comm = comm;
        this.summary = summary;
        this.causeAnalysis = causeAnalysis;
        this.solution = solution;
        this.createdAt = createdAt;
    }
}
