package com.example.aboutme.payment;

import com.example.aboutme.payment.enums.PaymentStatus;
import com.example.aboutme.user.User;
import com.example.aboutme.voucher.Voucher;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payment_tb")
@ToString(exclude = {"user", "voucher"})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 결제 ID

    @Column(nullable = false)
    private double amount; // 결제 금액

    @Column(nullable = false)
    private String paymentMethod; // 결제 방법

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 결제한 유저

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher; // 결제된 바우처

    @CreationTimestamp
    private Timestamp paymentDate; // 결제 날짜 및 시간

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status; // 결제 상태

    @Builder
    public Payment(Integer id, double amount, String paymentMethod, User user, Voucher voucher, Timestamp paymentDate, PaymentStatus status) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.voucher = voucher;
        this.paymentDate = paymentDate;
        this.status = status;
    }
}
