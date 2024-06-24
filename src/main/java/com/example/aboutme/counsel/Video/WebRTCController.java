package com.example.aboutme.counsel.Video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebRTCController {

    @GetMapping("/webrtc/status")
    public String getStatus() {
        return "client/counsel";
    }

    @GetMapping("/gg")
    public @ResponseBody String healthCheck() {
        return "메롱이다";
    }
}
