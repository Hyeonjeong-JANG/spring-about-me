INSERT INTO alarm_tb (message, receiver_id, sender_id, counsel_id, read, created_at)
VALUES
    -- 1번 클라이언트 알림
    ('상담이 완료되었습니다.', 1, 21, 1, true, NOW()),
    ('상담이 예약되었습니다.', 1, 21, 1, false, NOW()),
    ('상담이 예약되었습니다.', 1, 21, 1, false, NOW()),
    ('상담이 예약되었습니다.', 1, 21, 1, false, NOW()),
    -- 2번 클라이언트 알림
    ('상담이 완료되었습니다.', 2, 22, 2, true, NOW()),
    ('상담이 예약되었습니다.', 2, 22, 2, false, NOW()),
    ('상담이 예약되었습니다.', 2, 22, 2, false, NOW()),
    ('상담이 예약되었습니다.', 2, 22, 2, false, NOW()),
    -- 3번 클라이언트 알림
    ('상담이 완료되었습니다.', 3, 23, 3, true, NOW()),
    ('상담이 예약되었습니다.', 3, 23, 3, false, NOW()),
    ('상담이 예약되었습니다.', 3, 23, 3, false, NOW()),
    -- 4번 클라이언트 알림
    ('상담이 완료되었습니다.', 4, 24, 4, true, NOW()),
    ('상담이 예약되었습니다.', 4, 24, 4, true, NOW()),
    ('상담이 예약되었습니다.', 4, 24, 4, true, NOW()),
    ('상담이 예약되었습니다.', 4, 24, 4, true, NOW()),
    -- 5번 클라이언트 알림
    ('상담이 완료되었습니다.', 5, 25, 5, true, NOW()),
    -- 6번 클라이언트 알림
    ('상담이 완료되었습니다.', 6, 21, 6, true, NOW()),
    -- 7번 클라이언트 알림
    ('상담이 완료되었습니다.', 7, 22, 7, true, NOW()),
    -- 8번 클라이언트 알림
    ('상담이 완료되었습니다.', 8, 23, 8, true, NOW()),
    -- 9번 클라이언트 알림
    ('상담이 완료되었습니다.', 9, 24, 9, true, NOW()),
    -- 10번 클라이언트 알림
    ('상담이 완료되었습니다.', 10, 25, 10, true, NOW());
