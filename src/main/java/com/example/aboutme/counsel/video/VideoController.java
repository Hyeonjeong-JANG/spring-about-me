package com.example.aboutme.counsel.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {
    @GetMapping("/webrtc/status")
    public String getStatus() {
        return "video/counsel";
    }
}
