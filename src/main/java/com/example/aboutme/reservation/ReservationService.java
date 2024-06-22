package com.example.aboutme.reservation;

import com.example.aboutme._core.error.exception.Exception400;
import com.example.aboutme._core.utils.Formatter;
import com.example.aboutme._core.utils.NullHandlerUtil;
import com.example.aboutme.reservation.resrvationResponse.ReservationDetails.ReservationDetailsDTO;
import com.example.aboutme.schedule.Schedule;
import com.example.aboutme.schedule.ScheduleRepository;
import com.example.aboutme.voucher.Voucher;
import com.example.aboutme.voucher.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final VoucherRepository voucherRepository;
    private final ScheduleRepository scheduleRepository;
    private final Formatter formatter;


    //예약 페이지의 예약 가능 시간대 조회
    public ReservationDetailsDTO getReservationDetails(Integer voucherId, Integer expertId) {
        Voucher voucher = voucherRepository.findById(voucherId).orElseThrow(() -> new Exception400("해당하는 이용권을 찾을 수 없습니다."));
        List<Schedule> schedules = scheduleRepository.findByExpertId(expertId);
// 널 처리
        schedules = schedules.stream().map(NullHandlerUtil::handleNulls).toList();

        List<Reservation> reservations = reservationRepository.findByExpertId(expertId);
        // 가격 포맷
        String formattedPrice = formatter.number((int) voucher.getPrice());
        // 엔티티를 DTO로 변환
        ReservationDetailsDTO.VoucherDTO voucherDTO = new ReservationDetailsDTO.VoucherDTO(
                voucher.getId(),
                voucher.getVoucherType().getKorean(),
                voucher.getExpert().getId(),
                formattedPrice,
                voucher.getCount(),
                voucher.getDuration(),
                voucher.getImagePath(),
                voucher.getStartDate(),
                voucher.getCreatedAt().toLocalDateTime(),
                voucher.getUpdatedAt().toLocalDateTime()
        );

        List<ReservationDetailsDTO.ScheduleDTO> scheduleDTOs = schedules.stream()
                .map(schedule -> new ReservationDetailsDTO.ScheduleDTO(
                        schedule.getId(),
                        schedule.getExpert().getId(),
                        schedule.getStartTime(),
                        schedule.getEndTime(),
                        schedule.getRestType().getKorean(),
                        schedule.getStartDay().getKorean(),
                        schedule.getEndDay().getKorean(),
                        schedule.getSpecificDate(),
                        schedule.getLunchStartTime(),
                        schedule.getLunchEndTime()
                ))
                .collect(toList());

        List<ReservationDetailsDTO.ReservationDTO> reservationDTOs = reservations.stream()
                .map(reservation -> new ReservationDetailsDTO.ReservationDTO(
                        reservation.getId(),
                        reservation.getExpert().getId(),
                        reservation.getClient().getId(),
                        reservation.getVoucher().getId(),
                        reservation.getStatus().getKorean(),
                        reservation.getStartTime(),
                        reservation.getReservationDate(),
                        reservation.getSchedule().getId()
                ))
                .collect(toList());

        return new ReservationDetailsDTO(voucherDTO, scheduleDTOs, reservationDTOs);
    }

    @Transactional
    public void Reservation(Reservation reservation) {
        // 인증처리

        // 조건처리

        // 리스트
        List<Reservation> reservations = reservationRepository.findAll();

    }


}


