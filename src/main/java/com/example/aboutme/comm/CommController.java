package com.example.aboutme.comm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CommController {
    private final CommService commService;

    @GetMapping("/comm/write")
    public String community() {
        return "comm/comm-write";
    }

//    @GetMapping("/comm/comm-main")
//    public @ResponseBody List<CommDTO> communityPrint(HttpServletRequest req) {
//
//        List<CommDTO> comms = commService.printAllComm();
//        req.setAttribute("model",comms);
//
//        return comms;
//    }
}
