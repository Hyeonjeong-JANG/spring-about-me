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
@ToString(exclude = {"client", "expert", "payment"})
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 환불 아이디

    @Column(nullable = false)
    private Integer amount; // 환불 금액

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client; // 환불 요청한 클라이언트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id", nullable = false)
    private User expert; // 환불 승인한 익스퍼트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment; // 결제

    @CreationTimestamp
    private Timestamp refundDate; // 환불 날짜

    @Builder
    public Refund(Integer id, Integer amount, User client, User expert, Payment payment, Timestamp refundDate) {
        this.id = id;
        this.amount = amount;
        this.client = client;
        this.expert = expert;
        this.payment = payment;
        this.refundDate = refundDate;
    }
}

