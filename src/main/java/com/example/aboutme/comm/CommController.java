package com.example.aboutme.comm;

import com.example.aboutme.user.User;
import com.example.aboutme.user.enums.UserRole;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CommController {
    private final CommService commService;

    @GetMapping("/comm/write")
    public String communityWrite() {
        return "comm/comm-write";
    }

    @GetMapping("/comm-detail/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        CommResponse.CommDetailDTO comm = commService.getCommDetail(id);
        request.setAttribute("comm", comm);
        System.out.println("comm = " + comm);
        return "comm/comm-detail";
    }

    @GetMapping("/comm")
    public String community(HttpServletRequest request) {


        List<CommResponse.CommAndReplyDTO> commsWithReplyList = commService.findAllCommsWithReply();


        // 필터링 예시: 고유한 Comm에 대해 하나의 DTO만 추가하기
        CommResponse.UniqueCommAndReplyDTOFilter filter = new CommResponse.UniqueCommAndReplyDTOFilter();
        List<CommResponse.CommAndReplyDTO> filteredList = filter.filterUnique(commsWithReplyList);

        request.setAttribute("filteredList", filteredList);

        return "comm/comm-main";
    }
}
