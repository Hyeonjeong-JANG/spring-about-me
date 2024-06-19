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
    private Integer id; // 결제 아이디

    @Column(nullable = false)
    private Integer amount; // 결제 금액

    @Column(nullable = false)
    private String paymentMethod; // TODO: 결제 방식 결정

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 결제한 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher; // 바우처

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status; // COMPLETED: 결제 완료, PENDING: 결제 대기, FAILED: 결제 실패, REFUNDED:/ 환불

    @CreationTimestamp
    private Timestamp paymentDate;

    @Builder
    public Payment(Integer id, Integer amount, String paymentMethod, User user, Voucher voucher, PaymentStatus status, Timestamp paymentDate) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.voucher = voucher;
        this.status = status;
        this.paymentDate = paymentDate;
    }
}
