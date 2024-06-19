package com.example.aboutme.alarm;

import com.example.aboutme.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alarm_tb")
@ToString(exclude = {"user", "sender"})
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 알림 아이디

    @Column(nullable = false)
    private String message; // 알림 메시지

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 알림 받는 사용자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = true)
    private User sender; // 알림을 유발한 사용자 (발신자)

    @CreationTimestamp
    private Timestamp createdAt;

    public Alarm(Integer id, String message, User user, User sender, Timestamp createdAt) {
        this.id = id;
        this.message = message;
        this.user = user;
        this.sender = sender;
        this.createdAt = createdAt;
    }
}

