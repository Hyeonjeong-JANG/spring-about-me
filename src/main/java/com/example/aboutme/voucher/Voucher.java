package com.example.aboutme.voucher;

import com.example.aboutme.user.User;
import com.example.aboutme.voucher.enums.VoucherType;
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
@Table(name = "voucher_tb")
@ToString(exclude = {"expert"})
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 바우처 ID

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VoucherType voucherType; // 바우처 유형

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id", nullable = false)
    private User expert; // 바우처 제공 전문가

    @Column(nullable = false)
    private Integer price; // 가격

    @Column(nullable = false)
    private Integer count; // 사용 가능 횟수

    @Column(nullable = false)
    private Integer duration; // 바우처 유효 기간

    private String imagePath; // 이미지 경로

    @Column(nullable = false)
    private LocalDateTime startDate; // 시작 날짜

    @CreationTimestamp
    private Timestamp createdAt; // 생성 시간

    @UpdateTimestamp
    private Timestamp updatedAt; // 수정 시간

    @Builder
    public Voucher(Integer id, VoucherType voucherType, User expert, Integer price, Integer count, Integer duration, String imagePath, LocalDateTime startDate, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.voucherType = voucherType;
        this.expert = expert;
        this.price = price;
        this.count = count;
        this.duration = duration;
        this.imagePath = imagePath;
        this.startDate = startDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
