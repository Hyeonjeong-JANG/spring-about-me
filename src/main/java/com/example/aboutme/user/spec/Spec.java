package com.example.aboutme.user.spec;

import com.example.aboutme.user.User;
import com.example.aboutme.user.enums.SpecType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "spec_tb")
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 스펙 아이디

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpecType specType; // CAREER: 경력, EDUCATION: 학력

    @Column(nullable = false)
    private String details; // 상세 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String startYear; // 시작년도
    private String endYear; // 최종년도

    @Builder
    public Spec(Integer id, SpecType specType, String details, User user, String startYear, String endYear) {
        this.id = id;
        this.specType = specType;
        this.details = details;
        this.user = user;
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
