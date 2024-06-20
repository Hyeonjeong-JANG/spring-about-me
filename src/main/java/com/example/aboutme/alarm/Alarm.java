package com.example.aboutme.alarm;

import com.example.aboutme.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alarm_tb")
@ToString(exclude = "user")
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 알림 ID

    @Column(nullable = false)
    private String message; // 알림 메시지

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 알림을 받은 유저

    @CreationTimestamp
    private Timestamp createdAt; // 알림 생성 시간

    @Builder
    public Alarm(Integer id, String message, User user, Timestamp createdAt) {
        this.id = id;
        this.message = message;
        this.user = user;
        this.createdAt = createdAt;
    }
}
