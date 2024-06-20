package com.example.aboutme.counsel;

import com.example.aboutme.user.User;
import com.example.aboutme.voucher.Voucher;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "counsel_tb")
@ToString(exclude = {"client", "expert", "voucher", "review"})
public class Counsel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 상담 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client; // 상담을 받은 클라이언트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id", nullable = false)
    private User expert; // 상담을 제공한 전문가

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher; // 사용된 바우처

    @Column(nullable = false)
    private LocalDateTime counselDate; // 상담 날짜 및 시간

    @Column(nullable = false)
    private String result; // 상담 결과

    @CreationTimestamp
    private Timestamp createdAt; // 생성 시간

    @UpdateTimestamp
    private Timestamp updatedAt; // 수정 시간

    @Builder
    public Counsel(Integer id, User client, User expert, Voucher voucher, LocalDateTime counselDate, String result, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.client = client;
        this.expert = expert;
        this.voucher = voucher;
        this.counselDate = counselDate;
        this.result = result;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
