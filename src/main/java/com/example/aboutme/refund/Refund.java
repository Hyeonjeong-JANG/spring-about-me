package com.example.aboutme.refund;

import com.example.aboutme.payment.Payment;
import com.example.aboutme.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "refund_tb")
@ToString(exclude = {"user", "payment"})
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 환불 ID

    @Column(nullable = false)
    private double amount; // 환불 금액

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 환불받은 유저

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment; // 관련 결제 정보

    @CreationTimestamp
    private Timestamp refundDate; // 환불 날짜 및 시간

    @Builder
    public Refund(Integer id, double amount, User user, Payment payment, Timestamp refundDate) {
        this.id = id;
        this.amount = amount;
        this.user = user;
        this.payment = payment;
        this.refundDate = refundDate;
    }
}
