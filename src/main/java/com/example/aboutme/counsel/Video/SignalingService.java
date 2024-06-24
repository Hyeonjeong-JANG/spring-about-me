package com.example.aboutme.counsel.Video;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SignalingService {

    private ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public void handleMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 메시지 파싱 및 라우팅 로직 구현
        for (WebSocketSession s : sessions.values()) {
            if (!s.getId().equals(session.getId())) {
                s.sendMessage(message); // 메시지 브로드캐스트
            }
        }
    }

    public void registerSession(WebSocketSession session) {
        sessions.put(session.getId(), session);
    }

    public void unregisterSession(WebSocketSession session) {
        sessions.remove(session.getId());
    }
}
