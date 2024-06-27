package com.example.aboutme.user;

import com.example.aboutme._core.utils.RedisUtil;
import com.example.aboutme.user.UserResponseRecord.ClientMainDTO.ClientMainDTORecord;
import com.example.aboutme.user.UserResponseRecord.ExpertFindDetailDTO.DetailDTORecord;
import com.example.aboutme.user.UserResponseRecord.ExpertMainDTO.ExpertMainDTORecord;
import com.example.aboutme.user.UserResponseRecord.UserProfileDTO;
import com.example.aboutme.user.UserResponseRecord.expertFindDTO.FindWrapperRecord;
import com.example.aboutme.user.enums.OauthProvider;
import com.example.aboutme.user.enums.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemp;

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO, Model model, RedirectAttributes redirectAttributes) {
        SessionUser sessionUser = userService.loginByName(reqDTO);
        if (sessionUser == null) {
            throw new RuntimeException("아이디 혹은 패스워드가 틀렸습니다.");
        } else {
            // 세션 데이터를 저장
            redisUtil.saveSessionUser(sessionUser);
        }

        // 모델에 세션 데이터를 추가
        if (sessionUser.getUserRole() == UserRole.CLIENT) {
            return "redirect:/";
        } else if (sessionUser.getUserRole() == UserRole.EXPERT) {
            return "redirect:/experts";
        } else {
            return "oauth/login";
        }
    }

    @GetMapping("/redis/test")
    public @ResponseBody String redisTest() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        log.info("SessionUser: " + sessionUser);
        return "redis test";
    }

    @GetMapping("/expert/reply")
    public String expertReply() {
        return "expert/expert-reply";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "oauth/join";
    }


    @GetMapping("/login")
    public String loginForm() {
        return "oauth/login";
    }

    @PostMapping("/setUserRole")
    @ResponseBody
    public void setUserRole(@RequestParam("userRole") String userRoleStr) {
        redisUtil.saveUserRole(userRoleStr);
    }

    @GetMapping("/oauth/callback/kakao")
    public String kakaoCallback(@RequestParam("code") String code) {
        SessionUser sessionUser = userService.loginKakao(code, redisTemp);
        redisTemp.opsForValue().set("sessionUser", sessionUser);
        return "redirect:/";
    }

    @GetMapping("/oauth/callback/naver")
    public String naverCallback(@RequestParam(value = "code") String code,
                                @RequestParam("state") String state) {
        SessionUser sessionUser = userService.loginNaver(code, state, redisTemp);
        redisTemp.opsForValue().set("sessionUser", sessionUser);
        return "redirect:/";
    }

//    @GetMapping("/oauth/callback/kakao")
//    public String kakaoCallback(@RequestParam("code") String code) {
//        User sessionUser = kakaoOAuthService.login(code, null, session);
//        session.setAttribute("sessionUser", sessionUser);
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/oauth/callback/naver")
//    public String oauthNaverCallback(
//            @RequestParam(value = "code") String code,
//            @RequestParam("state") String state) {
//        User sessionUser = naverOAuthService.login(code, state, session);
//        session.setAttribute("sessionUser", sessionUser);
//
//        return "redirect:/";
//    }

//    @GetMapping("/oauth/callback/{provider}")
//    public String oauthCallback(
//            @PathVariable("provider") OauthProvider provider,
//            @RequestParam("code") String code,
//            @RequestParam(value = "state", required = false) String state,
//            HttpSession session) {
//
//        User sessionUser;
//
//        if (provider == OauthProvider.KAKAO) {
//            sessionUser = kakaoOAuthService.login(code, null, session);
//        } else if (provider == OauthProvider.NAVER) {
//            sessionUser = naverOAuthService.login(code, state, session);
//        } else {
//            throw new IllegalArgumentException("Unsupported OAuth provider: " + provider);
//        }
//
//        session.setAttribute("sessionUser", sessionUser);
//        return "redirect:/";
//    }


    @GetMapping("/logout")
    public String logout() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        if (sessionUser != null) {
            redisTemp.delete("sessionUser");
            redisTemp.delete("userRole");
            // OAuth 로그아웃 처리
            boolean isLoggedOut = false;
            if (sessionUser.getProvider() == OauthProvider.KAKAO) {
                isLoggedOut = userService.logoutKakao(sessionUser.getAccessToken());
            } else if (sessionUser.getProvider() == OauthProvider.NAVER) {
                isLoggedOut = userService.logoutNaver(sessionUser.getAccessToken());
            }

            // OAuth 로그아웃 성공 시 Redis에서 세션 정보 삭제
            if (isLoggedOut) {
                redisTemp.delete("sessionUser");
                redisTemp.delete("userRole");
            }
        }
        return "redirect:/login";
    }


    // 👻👻👻공통👻👻👻
    // 클라이언트 메인페이지
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("sessionUser", redisUtil.getSessionUser());
        ClientMainDTORecord clientMain = userService.getClientMain();
        model.addAttribute("clientMain", clientMain);
        return "client/main";
    }


    // 익스퍼트 메인페이지
    @GetMapping("/experts")
    public String expertMain(Model model) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        ExpertMainDTORecord expertMain = userService.getExpertMain(sessionUser);
        model.addAttribute("expertMain", expertMain);
        return "expert/main";
    }


    // 🐯🐯🐯Client🐯🐯🐯
    //전문가 찾기 - 메인
    @GetMapping("/client/findExpert")
    public String findExpert(Model model) {
        FindWrapperRecord findWrapperRecord = userService.getExpertFind();
        model.addAttribute("expertList", findWrapperRecord);

        SessionUser sessionUser = redisUtil.getSessionUser();
        log.info("SessionUser: " + sessionUser);

//        List<UserResponse.ExpertUserDTO> expertUserList = userService.getAllExpertUsers();
//        session.setAttribute("expertUserList", expertUserList);

        return "client/findExpert/main";
    }


    // 전문가 찾기 - 상세보기
    @GetMapping("/client/findExpert/detail/{expertId}")
    public String findExpertDetail(Model model, @PathVariable("expertId") Integer expertId) {
        DetailDTORecord detailDTORecord = userService.getFindExpertDetails(expertId);
        model.addAttribute("model", detailDTORecord);
        return "client/findExpert/detail";
    }

    //클라이언트 - 마이페이지
    @GetMapping("/client/myPage")
    public String clientmyPage(Model model) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        if (sessionUser == null) {
            return "oauth/login";
        } else {
            UserProfileDTO respDTO = userService.마이페이지정보(sessionUser);
            model.addAttribute("model", respDTO);

            return "client/myPage";
        }
    }

    //익스퍼트 - 마이페이지
    @GetMapping("/expert/myPage")
    public String expertmyPage() {
        return "expert/myPage";
    }
    // 🩺🩺🩺expert🩺🩺🩺
}
