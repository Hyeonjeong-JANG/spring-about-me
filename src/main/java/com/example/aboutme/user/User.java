package com.example.aboutme.user;

import com.example.aboutme.user.enums.Gender;
import com.example.aboutme.user.enums.UserRole;
import com.example.aboutme.user.pr.PR;
import com.example.aboutme.user.spec.Spec;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
@ToString(exclude = {"pr", "specs", "payments", "refunds", "alarms", "comms", "replies", "vouchers"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 유저 아이디

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole; // CLIENT, EXPERT

    @Column(nullable = false, unique = true)
    private String email; // 이메일 (아이디로 사용됨)

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(nullable = false)
    private String name; // 이름 (클라이언트는 닉네임, 전문가는 이름)

    @Column(nullable = false)
    private String phone; // 전화번호

    private String expertTitle; // 상담사 타이틀 (전문가에게만 해당)

    @Column(nullable = true)
    private String profileImage; // 프로필 이미지 경로

    private String birth; // 생년월일

    @Enumerated(EnumType.STRING)
    private Gender gender; // 성별

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PR pr; // 전문가 PR 정보

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Spec> specs; // 전문가 스펙 리스트

    @CreationTimestamp
    private Timestamp createdAt; // 생성 시간

    @UpdateTimestamp
    private Timestamp updatedAt; // 수정 시간

    @Builder
    public User(Integer id, UserRole userRole, String email, String password, String name, String phone, String profileImage, String birth, Gender gender, PR pr, List<Spec> specs, Timestamp createdAt, Timestamp updatedAt, String expertTitle) {
        this.id = id;
        this.userRole = userRole;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.profileImage = profileImage;
        this.birth = birth;
        this.gender = gender;
        this.pr = pr;
        this.specs = specs;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expertTitle = expertTitle;
    }
}
