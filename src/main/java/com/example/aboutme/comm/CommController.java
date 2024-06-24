package com.example.aboutme.comm;

import com.example.aboutme._core.utils.RedisUtil;
import com.example.aboutme.user.SessionUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CommController {
    private final CommService commService;
    private final RedisUtil redisUtil;

    @GetMapping("/comm/write")
    public String communityWrite() {
        return "comm/comm-write";
    }

    @GetMapping("/comm-detail/{id}")
    public String detail(@PathVariable("id") Integer id,
                         @RequestParam(value = "category") String category,
                         Model model) throws JsonProcessingException {

        SessionUser sessionUser = redisUtil.getSessionUser();
        CommResponse.CommDetailDTO comm = commService.getCommDetail(id);
        String json = new ObjectMapper().writeValueAsString(comm);
        System.out.println("json = " + json);
        
        // userRole이 EXPERT인 경우에는 true, 그 외에는 false
        model.addAttribute("comm", comm);
        model.addAttribute("isUserRole", sessionUser.isExpert());

        return "comm/comm-detail";
    }

    @GetMapping("/comm")
    public String community(HttpServletRequest request) {
        List<CommResponse.CommAndReplyDTO> commsWithReplyList = commService.findAllCommsWithReply();
        request.setAttribute("commsWithReplyList", commsWithReplyList);
        return "comm/comm-main";
    }
}
