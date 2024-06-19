package com.example.aboutme.voucher;

import com.example.aboutme.payment.Payment;
import com.example.aboutme.reservation.Reservation;
import com.example.aboutme.user.User;
import com.example.aboutme.voucher.enums.VoucherType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "voucher_tb")
@ToString(exclude = {"issuedBy", "ownedBy", "reservation", "payments"})
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 바우처 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issued_by", nullable = false)
    private User issuedBy; // 바우처 발행한 사람(expert)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owned_by", nullable = false)
    private User ownedBy; // 바우처 구매한 사람(client)

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation; // 예약

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VoucherType voucherType; // TEXT_THERAPY, VOICE_THERAPY, VIDEO_THERAPY

    @Column(nullable = false)
    private Integer price; // 바우처 가격

    @Column(nullable = false)
    private Integer count; // 바우처 횟수

    @Column(nullable = false)
    private Integer duration; // 상담 시간

    @Column(nullable = false)
    private Double discount; // 할인율

    @Column(nullable = false)
    private LocalDateTime startDate; // 바우처 개시 날짜

    private LocalDateTime endDate; // 바우처 사용 기한

    @Column(nullable = false)
    private Boolean isActive; // 바우처 활성 상태

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Payment> payments; // 결제

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Builder
    public Voucher(Integer id, User issuedBy, User ownedBy, Reservation reservation, VoucherType voucherType, Integer price, Integer count, Integer duration, Double discount, LocalDateTime startDate, LocalDateTime endDate, Boolean isActive, List<Payment> payments, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.issuedBy = issuedBy;
        this.ownedBy = ownedBy;
        this.reservation = reservation;
        this.voucherType = voucherType;
        this.price = price;
        this.count = count;
        this.duration = duration;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.payments = payments;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
