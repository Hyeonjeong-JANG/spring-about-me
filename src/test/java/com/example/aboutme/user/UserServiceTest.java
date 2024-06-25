package com.example.aboutme.user;

import com.example.aboutme._core.error.exception.Exception404;
import com.example.aboutme._core.utils.Formatter;
import com.example.aboutme.comm.CommRepository;
import com.example.aboutme.payment.PaymentRepository;
import com.example.aboutme.reservation.ReservationRepository;
import com.example.aboutme.reservation.enums.ReservationStatus;
import com.example.aboutme.user.UserResponseRecord.UserProfileDTO;
import com.example.aboutme.voucher.Voucher;
import com.example.aboutme.voucher.VoucherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CommRepository commRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    private final Formatter formatter = new Formatter();

    @Test
    void 마이페이지정보() throws JsonProcessingException {
        int id = 1;

        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 정보를 찾을 수 없습니다."));

        List<UserProfileDTO.VoucherDTO> vouchers = paymentRepository.findByClientId(id).stream()
                .map(payment -> {
                    Voucher v = payment.getVoucher();
                    Integer usedCount = reservationRepository.countByVoucherIdAndStatus(v.getId(), ReservationStatus.COMPLETED);
                    System.out.println("usedCount = " + usedCount);
                    Integer remainingCount = v.getCount() - usedCount;
                    System.out.println("remainingCount = " + remainingCount);
                    return UserProfileDTO.VoucherDTO.builder()
                            .id(v.getId())
                            .voucherType(v.getVoucherType().getKorean())
                            .expertId(v.getExpert().getId())
                            .price(formatter.number((int) v.getPrice()))
                            .count(v.getCount())
                            .remainingCount(remainingCount)  // 계산된 필드
                            .duration(v.getDuration())
                            .createdAt(v.getCreatedAt())
                            .updatedAt(v.getUpdatedAt())
                            .paymentDate(formatter.formatDate(payment.getPaymentDate()))
                            .build();
                })
                .toList();
            vouchers.forEach(voucherDTO -> System.out.println("voucherDTO = " + voucherDTO));
//        List<UserProfileDTO.ReservationDTO> reservations = reservationRepository.findByClientId(id).stream()
//                .map(r -> new UserProfileDTO.ReservationDTO(
//                        r.getId(), r.getExpert().getId(), r.getClient().getId(), r.getVoucher().getId(),
//                        r.getSchedule().getId(), r.getStatus().getKorean(), r.getStartTime(), r.getReservationDate(),
//                        r.getDayOfWeek(), r.getCreatedAt(), r.getUpdatedAt()))
//                .toList();
//
//        List<UserProfileDTO.Comm> commPosts = commRepository.findByUserId(id).stream()
//                .map(c -> new UserProfileDTO.Comm(
//                        c.getId(), c.getContent(), c.getTitle(), c.getCategory().getKorean()))
//                .toList();
//
//        UserProfileDTO userProfileDTO =  new UserProfileDTO(user, vouchers, reservations, commPosts);
//        String json = new ObjectMapper().writeValueAsString(userProfileDTO);
//        System.out.println("json = " + json);
    }
}