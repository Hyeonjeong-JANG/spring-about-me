package com.example.aboutme.comm;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class CommController {
    private final CommService commService;

    @GetMapping("/comm/write")
    public String community() {
        return "comm/comm-write";
    }

    //게시판 상세보기
    @GetMapping("/comm-detail/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        CommResponse.CommDetailDTO comm = commService.getCommDetail(id);
        request.setAttribute("comm", comm);
//        System.out.println("comm = " + comm);
        return "comm/comm-detail";
    }


}
