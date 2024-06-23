package com.example.aboutme.counsel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webrtc")
public class WebRTCController {

    @GetMapping("/status")
    public String getStatus() {
        return "client/counsel";
    }
}
