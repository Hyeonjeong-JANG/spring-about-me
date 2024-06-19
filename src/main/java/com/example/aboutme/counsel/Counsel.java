package com.example.aboutme.counsel;

import com.example.aboutme.review.Review;
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
    private Integer id; // 상담 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client; // 상담 받는 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id", nullable = false)
    private User expert; // 상담 해주는 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher; // 사용된 바우처

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = true)
    private Review review; // 상담 리뷰

    @Column(nullable = false)
    private LocalDateTime counselDate; // 상담 날짜

    @Column(nullable = false)
    private String result; // 상담 결과

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

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
