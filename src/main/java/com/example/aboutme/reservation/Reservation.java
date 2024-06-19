package com.example.aboutme.reservation;

import com.example.aboutme.reservation.enums.ReservationStatus;
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
@Table(name = "reservation_tb")
@ToString(exclude = {"expert", "client", "voucher"})
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 상담 예약 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id", nullable = false)
    private User expert; // 상담 해주는 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client; // 상담 받는 사람

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher; // 어떤 바우처를 썼는지

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status; // SCHEDULED: 예약이 예정된 상태, COMPLETED: 예약이 완료된 상태, CANCELLED: 예약이 취소된 상태

    @Column(nullable = false)
    private String startTime; // 상담 시작 날짜

    @Column(nullable = false)
    private LocalDateTime reservationDate; // 예약 날짜

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Builder
    public Reservation(Integer id, User expert, User client, Voucher voucher, ReservationStatus status, String startTime, LocalDateTime reservationDate, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.expert = expert;
        this.client = client;
        this.voucher = voucher;
        this.status = status;
        this.startTime = startTime;
        this.reservationDate = reservationDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
