package com.example.aboutme.user;

import com.example.aboutme._core.error.exception.Exception403;
import com.example.aboutme._core.utils.Formatter;
import com.example.aboutme.comm.CommRepository;
import com.example.aboutme.counsel.Counsel;
import com.example.aboutme.counsel.CounselRepository;
import com.example.aboutme.review.ReviewRepository;
import com.example.aboutme.user.UserResponseDTO.ClientMainDTO.ClientMainDTORecord;
import com.example.aboutme.user.UserResponseDTO.ClientMainDTO.CommDTORecord;
import com.example.aboutme.user.UserResponseDTO.ClientMainDTO.ExpertDTORecord;
import com.example.aboutme.user.UserResponseDTO.ClientMainDTO.VoucherDTORecord;
import com.example.aboutme.user.UserResponseDTO.ExpertFindDetailDTO.*;
import com.example.aboutme.user.UserResponseDTO.ExpertMainDTO.CounselScheduleRecord;
import com.example.aboutme.user.UserResponseDTO.ExpertMainDTO.ExpertMainDTORecord;
import com.example.aboutme.user.UserResponseDTO.ExpertMainDTO.RecentReviewRecord;
import com.example.aboutme.user.UserResponseDTO.expertFindDTO.ExpertInfoRecord;
import com.example.aboutme.user.UserResponseDTO.expertFindDTO.FindWrapperRecord;
import com.example.aboutme.user.UserResponseDTO.expertFindDTO.VoucherImageRecord;
import com.example.aboutme.user.enums.SpecType;
import com.example.aboutme.user.enums.UserRole;
import com.example.aboutme.user.pr.PRRepository;
import com.example.aboutme.user.spec.SpecRepository;
import com.example.aboutme.voucher.Voucher;
import com.example.aboutme.voucher.VoucherRepository;
import com.example.aboutme.voucher.enums.VoucherType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final CommRepository commRepository;
    private final UserNativeRepository userNativeRepository;
    private final ReviewRepository reviewRepository;
    private final VoucherRepository voucherRepository;
    private final SpecRepository specRepository;
    private final PRRepository prRepository;
    private final CounselRepository counselRepository;
    private final Formatter formatter;

//회원가입
//    @Transactional
//    public void joinByEmail(UserRequest.JoinDTO reqDTO){
//        userNativeRepository.join(reqDTO);
//    }
//
    //    //로그인
//    public User loginByName(UserRequest.LoginDTO reqDTO) {
//        User sessionUser = userNativeRepository.login(reqDTO);
//        return sessionUser;
//    }

    @Transactional
    public User loginByName(UserRequest.LoginDTO reqDTO) {
        User user = userNativeRepository.login(reqDTO);
        user.getSpecs().size();
        return user;
    }

    public DetailDTORecord getFindExpertDetails(Integer expertId) {
        User user = userRepository.findById(expertId).orElseThrow(() -> new Exception403("유저정보를 찾을 수 없습니다."));
        UserRecord userRecord = new UserRecord(user.getId(), user.getName(), user.getProfileImage());

        double price = voucherRepository.findLowestPriceByExpertId(expertId);
        String lowestPrice = formatter.number((int) price); // 포맷터에서 가격을 포맷팅

        List<ReviewRecord> reviewRecords = reviewRepository.findByExpertId(expertId).stream()
                .map(review -> new ReviewRecord(review.getId(), review.getContent()))
                .collect(Collectors.toList());

        List<PRRecord> prRecords = prRepository.findByExpertId(expertId).stream()
                .map(pr -> new PRRecord(pr.getUser().getId(), pr.getIntro(), pr.getEffects(), pr.getMethods()))
                .collect(Collectors.toList());

        // 학력과 경력을 각각 나눔
        List<SpecRecord> careerRecords = specRepository.findByExpertId(expertId).stream()
                .filter(spec -> spec.getSpecType() == SpecType.CAREER)
                .map(spec -> new SpecRecord(spec.getUser().getId(), spec.getSpecType(), spec.getDetails()))
                .collect(Collectors.toList());

        List<SpecRecord> educationRecords = specRepository.findByExpertId(expertId).stream()
                .filter(spec -> spec.getSpecType() == SpecType.EDUCATION)
                .map(spec -> new SpecRecord(spec.getUser().getId(), spec.getSpecType(), spec.getDetails()))
                .collect(Collectors.toList());

        return new DetailDTORecord(userRecord, lowestPrice, reviewRecords, prRecords, careerRecords, educationRecords);
    }


    // 상담가리스트 (record)
    public FindWrapperRecord getExpertFind() {

        // 1. 모든 유저 찾기
        List<User> users = userRepository.findAll();

        // 2. userRole이 EXPERT인 유저만 필터링
        List<User> expertUsers = users.stream()
                .filter(user -> user.getUserRole() == UserRole.EXPERT)
                .toList();

        // 3.ExpertinfoDTO 생성
        List<ExpertInfoRecord> expertInfos = expertUsers.stream().map(user -> {

            //4. voucher 이미지 찾기
            List<Voucher> vouchersImages = voucherRepository.findByExpertId(user.getId());

            List<VoucherImageRecord> voucherImageDTOs = vouchersImages.stream().map(voucher -> {
                return new VoucherImageRecord(voucher.getImagePath());
            }).toList();

            return new ExpertInfoRecord(user.getId(), user.getName(), user.getExpertTitle(), user.getProfileImage(), voucherImageDTOs);
        }).toList();

        return new FindWrapperRecord(expertInfos);

    }

    // 상담가 검색
    public FindWrapperRecord getExpertFindBySearch(LocalDateTime localDateTime) {

        // 1. 모든 유저 찾기
        List<User> users = userRepository.findAll();

        // 2. userRole이 EXPERT인 유저만 필터링
        List<User> expertUsers = users.stream()
                .filter(user -> user.getUserRole() == UserRole.EXPERT)
                .filter(user -> {
                    List<Counsel> counsels = counselRepository.findCounselsByDateAndTime(localDateTime);
                    return counsels.stream().noneMatch(counsel -> counsel.getClient().getId().equals(user.getId()));
                })
                .toList();

        // 3.ExpertinfoDTO 생성
        List<ExpertInfoRecord> expertInfos = expertUsers.stream().map(user -> {

            //4. voucher 이미지 찾기
            List<Voucher> vouchersImages = voucherRepository.findByExpertId(user.getId());

            List<VoucherImageRecord> voucherImageDTOs = vouchersImages.stream().map(voucher -> {
                return new VoucherImageRecord(voucher.getImagePath());
            }).toList();

            return new ExpertInfoRecord(user.getId(), user.getName(), user.getExpertTitle(), user.getProfileImage(), voucherImageDTOs);
        }).toList();

        return new FindWrapperRecord(expertInfos);

    }


    // 클라이언트 메인
    public ClientMainDTORecord getClientMain() {
        List<CommDTORecord> comms = commRepository.findCommsWithReply().stream()
                .map(comm -> new CommDTORecord(
                        comm.getCommunityId(),
                        comm.getWriterName(),
                        comm.getWriterImage(),
                        comm.getExpertName(),
                        comm.getExpertImage(),
                        comm.getTitle(),
                        comm.getContent(),
                        comm.getCategory()))
                .toList();

        List<ExpertDTORecord> experts = userRepository.findExpert().stream()
                .map(expert -> {
                    List<VoucherDTORecord> vouchers = voucherRepository.findByExpertId(expert.getExpertId()).stream()
                            .map(voucher -> new VoucherDTORecord(
                                    voucher.getVoucherType(),
                                    voucher.getPrice(),
                                    voucher.getDuration()))
                            .toList();

                    boolean hasTextTherapy = vouchers.stream()
                            .anyMatch(voucher -> voucher.voucherType() == VoucherType.TEXT_THERAPY);
                    boolean hasVoiceTherapy = vouchers.stream()
                            .anyMatch(voucher -> voucher.voucherType() == VoucherType.VOICE_THERAPY);
                    boolean hasVideoTherapy = vouchers.stream()
                            .anyMatch(voucher -> voucher.voucherType() == VoucherType.VIDEO_THERAPY);

                    return new ExpertDTORecord(
                            expert.getExpertId(),
                            expert.getName(),
                            expert.getProfileImage(),
                            expert.getExpertTitle(),
                            vouchers,
                            hasTextTherapy,
                            hasVoiceTherapy,
                            hasVideoTherapy);
                })
                .toList();

        return new ClientMainDTORecord(comms, experts);
    }

    // 익스퍼트 메인
    @Transactional
    public ExpertMainDTORecord getExpertMain(Integer expertId) {
        List<RecentReviewRecord> recentReviewRecords = reviewRepository.findReviewRecordsByExpertId(expertId);
        List<CounselScheduleRecord> counselScheduleRecords = counselRepository.findCounselScheduleRecordsByExpertId(expertId);

        return new ExpertMainDTORecord(recentReviewRecords, counselScheduleRecords);
    }
}
