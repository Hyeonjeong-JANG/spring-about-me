package com.example.aboutme.alarm;

import com.example.aboutme.reservation.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class AlarmService {
    private final AlarmRepository alarmRepository;

    private final Map<Integer, SseEmitter> expertEmitters = new ConcurrentHashMap<>();
    private final Map<Integer, SseEmitter> clientEmitters = new ConcurrentHashMap<>();

    public SseEmitter registerExpert(Integer expertId) {
        SseEmitter emitter = new SseEmitter();
        expertEmitters.put(expertId, emitter);
        emitter.onCompletion(() -> expertEmitters.remove(expertId));
        emitter.onTimeout(() -> expertEmitters.remove(expertId));
        return emitter;
    }

    public SseEmitter registerClient(Integer clientId) {
        SseEmitter emitter = new SseEmitter();
        clientEmitters.put(clientId, emitter);
        emitter.onCompletion(() -> clientEmitters.remove(clientId));
        emitter.onTimeout(() -> clientEmitters.remove(clientId));
        return emitter;
    }

    public void alarmExpert(Reservation reservation) {
        SseEmitter emitter = expertEmitters.get(reservation.getExpert().getId());
        if (emitter != null) {
            try {
                emitter.send("새로운 예약이 도착했습니다.");
            } catch (IOException e) {
                expertEmitters.remove(reservation.getExpert().getId());
            }
        }
    }

    public void alarmClient(Reservation reservation) {
        SseEmitter emitter = clientEmitters.get(reservation.getClient().getId());
        if (emitter != null) {
            try {
                emitter.send("예약이 확정되었습니다.");
            } catch (IOException e) {
                clientEmitters.remove(reservation.getClient().getId());
            }
        }
    }
}
