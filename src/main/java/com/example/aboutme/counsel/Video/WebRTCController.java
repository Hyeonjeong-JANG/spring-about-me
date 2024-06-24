package com.example.aboutme.counsel.Video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webrtc")
public class WebRTCController {

    @GetMapping("/status")
    public String getStatus() {
        return "client/counsel";
    }

    @GetMapping("/")
    public @ResponseBody String healthCheck() {
        return "메롱이다";
    }
}
