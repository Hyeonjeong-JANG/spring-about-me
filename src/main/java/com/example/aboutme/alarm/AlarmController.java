package com.example.aboutme.alarm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
@Controller
public class AlarmController {
    private final AlarmService alarmService;

    @GetMapping("/sse/expert/{expertId}")
    public SseEmitter connectExpert(@PathVariable("expertId") Integer expertId) {
        return alarmService.registerExpert(expertId);
    }

    @GetMapping("/sse/client/{clientId}")
    public SseEmitter connectClient(@PathVariable("clientId") Integer clientId) {
        return alarmService.registerClient(clientId);
    }
}
