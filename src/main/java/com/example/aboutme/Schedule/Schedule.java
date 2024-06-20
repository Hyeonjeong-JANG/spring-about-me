package com.example.aboutme.Schedule;

import com.example.aboutme.review.enums.RestType;
import com.example.aboutme.user.User;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule_tb")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "counselor_id", nullable = false)
    private User counselor;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // 'AVAILABLE', 'RESERVED', 'REST'

    @Enumerated(EnumType.STRING)
    private RestType restType; // DAILY, WEEKLY, DATE_SPECIFIC, TIME_SPECIFIC

    private DayOfWeek dayOfWeek; // 휴식이 매주 발생하는 경우

    private LocalDate specificDate; // 특정 날짜에 발생하는 경우

    // Getters and Setters
}

