-- user_tb (유저)
INSERT INTO user_tb (user_role, email, password, name, phone, profile_image, birth, gender, created_at, updated_at)
VALUES ('CLIENT', 'mimi@nate.com', '1234', '최미정', '0101112222', 'client1.jpg', '1990-01-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'hae@nate.com', '1234', '장현재', '0101112222', 'client2.jpg', '1992-02-02', 'MAN', NOW(), NOW()),
       ('CLIENT', 'sae@nate.com', '1234', '이사이', '0101112222', 'client3.jpg', '1994-03-03', 'OTHER', NOW(), NOW()),
       ('CLIENT', 'jin@nate.com', '1234', '김진호', '0101112222', 'client4.jpg', '1996-04-04', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'ji@nate.com', '1234', '서지호', '0101112222', 'client5.jpg', '1998-05-05', 'MAN', NOW(), NOW()),
       ('CLIENT', 'suji@nate.com', '1234', '박수지', '0101113333', 'client6.jpg', '1990-06-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'jong@nate.com', '1234', '김종현', '0101114444', 'client7.jpg', '1991-07-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'yuna@nate.com', '1234', '윤아름', '0101115555', 'client8.jpg', '1992-08-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'minho@nate.com', '1234', '최민호', '0101116666', 'client9.jpg', '1993-09-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'sohee@nate.com', '1234', '이소희', '0101117777', 'client10.jpg', '1994-10-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'doyoung@nate.com', '1234', '박도영', '0101118888', 'client11.jpg', '1995-11-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'yeseul@nate.com', '1234', '김예슬', '0101119999', 'client12.jpg', '1996-12-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'dongwoo@nate.com', '1234', '정동우', '0101110000', 'client13.jpg', '1997-01-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'hyunjoo@nate.com', '1234', '박현주', '0102221111', 'client14.jpg', '1998-02-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'sanghoon@nate.com', '1234', '김상훈', '0102222222', 'client15.jpg', '1999-03-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'eunji@nate.com', '1234', '서은지', '0102223333', 'client16.jpg', '2000-04-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'woojin@nate.com', '1234', '이우진', '0102224444', 'client17.jpg', '2001-05-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'jiwon@nate.com', '1234', '최지원', '0102225555', 'client18.jpg', '2002-06-01', 'WOMAN', NOW(), NOW()),
       ('CLIENT', 'taeyoung@nate.com', '1234', '박태영', '0102226666', 'client19.jpg', '2003-07-01', 'MAN', NOW(), NOW()),
       ('CLIENT', 'soyoung@nate.com', '1234', '김소영', '0102227777', 'client20.jpg', '2004-08-01', 'WOMAN', NOW(), NOW());



INSERT INTO user_tb (user_role, email, password, name, phone, profile_image, birth, gender, created_at, updated_at,
                     expert_title)
VALUES ('EXPERT', 'expert1@nate.com', '1234', '홍길동', '01012345678', 'expert21.jpg', '1985-06-06', 'MAN', NOW(), NOW(),
        '혼자 걷다 보면 외롭고 지칠 때가 있습니다. 당신의 길에 함께하는 동반자가 되고 싶습니다.'),
       ('EXPERT', 'expert2@nate.com', '1234', '이영희', '01087654321', 'expert22.jpg', '1987-07-07', 'WOMAN', NOW(), NOW(),
        '저는 당신의 이야기가 궁금하네요. 조금 더 자세하게 말씀해주실 수 있을까요?'),
       ('EXPERT', 'expert3@nate.com', '1234', '박철수', '0103334444', 'expert23.jpg', '1980-01-01', 'MAN', NOW(), NOW(),
        '어떤 마음이어도, 어떤 모습이어도 다 괜찮습니다.'),
       ('EXPERT', 'expert4@nate.com', '1234', '김미영', '0103335555', 'expert24.jpg', '1982-02-02', 'WOMAN', NOW(), NOW(),
        '자신을 비춰보며 따뜻하게 어루만져 줄 수 있는 시간을 만들어드리고 싶은 상담사 백소림입니다.'),
       ('EXPERT', 'expert5@nate.com', '1234', '이종현', '0103336666', 'expert25.jpg', '1984-03-03', 'MAN', NOW(), NOW(),
        '말의 힘을 믿기에 한 마디 한 마디에 진심을 담아 당신의 이야기를 듣고 더하겠습니다.'),
       ('EXPERT', 'expert6@nate.com', '1234', '윤정희', '0103337777', 'expert26.jpg', '1986-04-04', 'WOMAN', NOW(), NOW(),
        '어떤 문제로 고민하세요?  함께 해요 ! 용기가 생겨요! 미래가 보여요!'),
       ('EXPERT', 'expert7@nate.com', '1234', '최현우', '0103338888', 'expert27.jpg', '1988-05-05', 'MAN', NOW(), NOW(),
        '그럼에도 불구하고 우리가 우리인 채로 잘 살아갈 수 있어요.'),
       ('EXPERT', 'expert8@nate.com', '1234', '김소정', '0103339999', 'expert28.jpg', '1990-06-06', 'WOMAN', NOW(), NOW(),
        '당신 안의 온전함을 다시 찾을 수 있게, 지친 마음이 쉬었다 갈 수 있게 함께 할게요. '),
       ('EXPERT', 'expert9@nate.com', '1234', '박재호', '0104441111', 'expert29.jpg', '1992-07-07', 'MAN', NOW(), NOW(),
        '당신에게 소금 같은 사람이 되어 드리고 싶습니다.'),
       ('EXPERT', 'expert10@nate.com', '1234', '이유리', '0104442222', 'expert30.jpg', '1994-08-08', 'WOMAN', NOW(), NOW(),
        '괜찮지 않은 그 순간, 온 마음으로 당신의 곁에 있겠습니다.');

-- voucher_tb
INSERT INTO voucher_tb (expert_id, client_id, reservation_id, voucher_type, price, count, duration, discount,
                        start_date, end_date, is_active, image_path, created_at, updated_at)
VALUES
    -- Expert 1
    (21, 1, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (21, 2, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (21, 3, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 2
    (22, 4, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (22, 5, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (22, 6, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 3
    (23, 7, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (23, 8, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (23, 9, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 4
    (24, 10, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (24, 11, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (24, 12, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 5
    (25, 13, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (25, 14, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (25, 15, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 6
    (26, 16, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (26, 17, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (26, 18, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 7
    (27, 19, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (27, 20, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (27, 1, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 8
    (28, 2, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (28, 3, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (28, 4, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 9
    (29, 5, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (29, 6, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (29, 7, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW()),
    -- Expert 10
    (30, 8, NULL, 'TEXT_THERAPY', 10000, 1, 60, 0.1, NOW(), NULL, TRUE, '/images/chat.png', NOW(), NOW()),
    (30, 9, NULL, 'VOICE_THERAPY', 15000, 1, 30, 0.2, NOW(), NULL, TRUE, '/images/call.png', NOW(), NOW()),
    (30, 10, NULL, 'VIDEO_THERAPY', 20000, 1, 45, 0.15, NOW(), NULL, TRUE, '/images/video.png', NOW(), NOW());

-- reservation_tb
INSERT INTO reservation_tb (expert_id, client_id, voucher_id, status, start_time, reservation_date, created_at,
                            updated_at)
VALUES
    -- Expert 1's Vouchers
    (21, 1, 1, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (21, 2, 2, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    (21, 3, 3, 'SCHEDULED', '12:00', NOW(), NOW(), NOW()),
    -- Expert 2's Vouchers
    (22, 4, 4, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (22, 5, 5, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    (22, 6, 6, 'SCHEDULED', '12:00', NOW(), NOW(), NOW()),
    -- Expert 3's Vouchers
    (23, 7, 7, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (23, 8, 8, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    (23, 9, 9, 'SCHEDULED', '12:00', NOW(), NOW(), NOW()),
    -- Expert 4's Vouchers
    (24, 10, 10, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (24, 11, 11, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    -- Expert 5's Vouchers
    (25, 13, 13, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (25, 14, 14, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    -- Expert 6's Vouchers
    (26, 16, 16, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (26, 17, 17, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    -- Expert 7's Vouchers
    (27, 19, 19, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (27, 20, 20, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    -- Expert 8's Vouchers
    (28, 1, 22, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (28, 2, 23, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    -- Expert 9's Vouchers
    (29, 4, 25, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (29, 5, 26, 'SCHEDULED', '11:00', NOW(), NOW(), NOW()),
    -- Expert 10's Vouchers
    (30, 7, 28, 'SCHEDULED', '10:00', NOW(), NOW(), NOW()),
    (30, 8, 29, 'SCHEDULED', '11:00', NOW(), NOW(), NOW());


-- comm_tb
INSERT INTO comm_tb (user_id, content, title, category, created_at)
VALUES (1, '집에 가고 싶어서 고민 적습니다', '집에 가고 싶어요', 'GENERAL_CONCERNS', NOW()),
       (1, '회사에서 스트레스 받아요', '회사 고민', 'WORK_LIFE', NOW()),
       (2, '저녁 메뉴를 못 정하겠어요. 추천받고 싶습니다', '배고파요', 'GENERAL_CONCERNS', NOW()),
       (2, '다이어트 중인데 뭐 먹죠?', '다이어트 고민', 'GENERAL_CONCERNS', NOW()),
       (3, '수업시간에 잠이 오면 어떻게 해야 할까요?', '매일매일 졸아요', 'GENERAL_CONCERNS', NOW()),
       (3, '시험 공부가 너무 힘들어요', '시험이 다가오는 것이 무서워요', 'GENERAL_CONCERNS', NOW()),
       (4, '친구와 싸웠어요', '친구 고민', 'SOCIAL_INTERACTIONS', NOW()),
       (4, '여행 가고 싶은데 어디가 좋을까요?', '여행 고민', 'GENERAL_CONCERNS', NOW()),
       (5, '취미를 찾고 싶어요', '취미 고민', 'GENERAL_CONCERNS', NOW()),
       (5, '운동을 시작해보려고 하는데...', '나가기 싫어요', 'GENERAL_CONCERNS', NOW()),
       (6, '혼자 밥 먹기 너무 싫어요', '혼밥 고민', 'SOCIAL_INTERACTIONS', NOW()),
       (6, '영화 추천 좀 해주세요', '영화 고민', 'GENERAL_CONCERNS', NOW()),
       (7, '새로운 프로젝트가 너무 어려워요', '프로젝트 고민', 'WORK_LIFE', NOW()),
       (7, '팀원과의 갈등이 있어요', '팀원 고민', 'WORK_LIFE', NOW()),
       (8, '자기계발을 어떻게 해야 할까요?', '자기계발 고민', 'CAREER_JOBS', NOW()),
       (8, '취업 준비가 막막해요', '취업ㅠㅠ', 'CAREER_JOBS', NOW()),
       (9, '연애가 너무 어려워요', '연애.................. 어려움', 'RELATIONSHIPS', NOW()),
       (9, '혼자서도 잘 할 수 있을까요?', '혼자 고민', 'GENERAL_CONCERNS', NOW()),
       (10, '집에서 취미 생활 하기 좋은 게 뭐가 있을까요?', '취미 생활', 'GENERAL_CONCERNS', NOW()),
       (10, '심리학 책 추천 좀 해주세요', '마음을 책으로 배울 수 있을까요?', 'GENERAL_CONCERNS', NOW());

-- reply_tb
INSERT INTO reply_tb (user_id, comm_id, summary, cause_analysis, solution, created_at)
VALUES
    -- 글 1의 댓글
    (1, 1, '집에 가고 싶은 이유는...', '스트레스가 원인입니다', '휴식을 취하세요', NOW()),
    (21, 1, '상담사 의견', '생활 속 스트레스가 주요 원인입니다.', '정기적인 휴식과 상담을 추천합니다.', NOW()),
    -- 글 2의 댓글
    (2, 2, '회사에서 스트레스 받는 이유는...', '업무 부담이 원인입니다', '업무 분담을 요청해보세요', NOW()),
    -- 글 3의 댓글
    (3, 3, '저녁 메뉴 고민', '다양한 옵션이 많아 결정이 어렵습니다', '가볍게 샐러드나 요거트를 추천합니다', NOW()),
    (22, 3, '상담사 의견', '건강한 다이어트를 위해 균형 잡힌 식사를 추천합니다.', '영양소가 균형 잡힌 식단을 고려해보세요.', NOW()),
    -- 글 5의 댓글
    (5, 5, '수업시간 졸음 원인', '수면 부족이 원인입니다', '충분한 수면을 취하세요', NOW()),
    -- 글 6의 댓글
    (4, 6, '시험 공부 힘든 이유', '과도한 학습량이 원인입니다', '적절한 학습 계획을 세우세요', NOW()),
    (23, 6, '상담사 의견', '효과적인 학습 방법을 찾는 것이 중요합니다.', '짧은 휴식과 함께 계획적인 학습을 추천합니다.', NOW()),
    -- 글 7의 댓글
    (5, 7, '친구와의 갈등 원인', '의사소통 부족이 원인입니다', '서로 솔직하게 대화해보세요', NOW()),
    -- 글 9의 댓글
    (27, 9, '취미 찾기 고민', '취미가 다양해 결정이 어렵습니다', '여러 가지 시도해보세요', NOW()),
    -- 글 12의 댓글
    (28, 12, '혼자 밥 먹기 싫은 이유', '외로움이 원인입니다', '가벼운 외출을 해보세요', NOW()),
    (30, 12, '상담사 의견', '혼자 있는 시간도 소중하게 생각하세요.', '작은 취미를 가져보세요.', NOW()),
    -- 글 14의 댓글
    (29, 14, '프로젝트 어려운 이유', '프로젝트 범위가 큽니다', '작게 나눠서 진행하세요', NOW()),
    (26, 14, '상담사 의견', '프로젝트 관리가 중요합니다.', '체계적인 계획을 세워보세요.', NOW()),
    -- 글 18의 댓글
    (30, 18, '연애가 어려운 이유', '서로의 이해가 부족합니다', '서로에게 솔직해지세요', NOW()),
    (27, 18, '상담사 의견', '서로의 감정을 잘 이해하세요.', '솔직한 대화를 나누세요.', NOW());

-- pr_tb
INSERT INTO pr_tb (expert_id, intro, effects, methods)
VALUES (21, '혼자 고민하지 마세요. 용기가 당신을 행복하게 만들 것입니다. 숨겨진 보물을 찾아내는 기쁨을 함께 경험하세요.',
        '문제의 원인은 모두 다릅니다. 사람마다 환경과 감정도 다르죠. 개개인의 상담 목표와 달성 방법, 효과에는 차이가 있습니다.',
        '상담 초기 단계에서는 상담신청 동기와 욕구, 문제파악과 목표를 설정합니다. 중기 단계에서는 억압된 감정표출과 문제 해결을 위한 심리적 여정을 돕습니다.'),
       (22, '혼자서 힘들어하지 마세요. 상담을 통해 새로운 시각을 얻고 행복을 찾으세요.',
        '각 개인의 문제와 상황에 맞춘 상담을 통해 더 나은 해결책을 찾을 수 있습니다.',
        '상담 초기에 문제를 파악하고 목표를 설정합니다. 중기에는 감정을 표출하고 해결책을 모색합니다.'),
       (23, '상담을 통해 마음의 짐을 덜어내세요. 함께 해결책을 찾아 나갑시다.',
        '다양한 문제 상황에 맞춘 맞춤형 상담을 제공합니다. 개인의 특성을 고려한 상담을 통해 효과적인 해결을 돕습니다.',
        '초기 상담 단계에서는 문제를 파악하고 목표를 설정합니다. 중기에는 억눌린 감정을 해소하고 문제 해결을 위한 심리적 접근을 시도합니다.'),
       (24, '상담을 통해 새로운 시작을 만들어 보세요. 함께 성장할 수 있습니다.',
        '각 개인의 문제와 상황에 맞춘 개별 상담을 통해 최선의 해결책을 찾습니다.',
        '상담 초기에는 상담신청 동기와 문제를 파악하고 목표를 설정합니다. 중기에는 감정표출과 문제 해결을 위한 접근을 시도합니다.'),
       (25, '상담을 통해 마음의 평안을 찾으세요. 함께 더 나은 내일을 준비합시다.',
        '각기 다른 문제와 상황에 맞춘 상담을 통해 효과적인 해결책을 제공합니다.',
        '초기 단계에서는 상담신청 동기와 문제를 파악하고 목표를 설정합니다. 중기에는 감정을 표출하고 문제 해결을 위한 심리적 접근을 합니다.'),
       (26, '혼자 고민하지 마세요. 상담을 통해 마음의 짐을 덜어내세요.',
        '개개인의 문제에 맞춘 상담을 통해 최적의 해결책을 찾습니다.',
        '상담 초기 단계에서는 문제를 파악하고 목표를 설정합니다. 중기에는 감정표출과 문제 해결을 위한 접근을 시도합니다.'),
       (27, '상담을 통해 새로운 길을 찾아보세요. 함께 더 나은 미래를 준비합시다.',
        '문제와 상황에 맞춘 개별 상담을 통해 최선의 해결책을 찾습니다.',
        '상담 초기 단계에서는 문제를 파악하고 목표를 설정합니다. 중기에는 억눌린 감정을 해소하고 문제 해결을 위한 접근을 시도합니다.'),
       (28, '상담을 통해 마음의 짐을 덜어내세요. 새로운 시작을 함께 만들어갑시다.',
        '각 개인의 문제에 맞춘 맞춤형 상담을 통해 최적의 해결책을 찾습니다.',
        '초기 상담 단계에서는 문제를 파악하고 목표를 설정합니다. 중기에는 감정을 표출하고 문제 해결을 위한 접근을 시도합니다.'),
       (29, '상담을 통해 마음의 평안을 찾으세요. 함께 더 나은 내일을 준비합시다.',
        '각기 다른 문제와 상황에 맞춘 상담을 통해 효과적인 해결책을 제공합니다.',
        '초기 단계에서는 상담신청 동기와 문제를 파악하고 목표를 설정합니다. 중기에는 감정을 표출하고 문제 해결을 위한 심리적 접근을 합니다.'),
       (30, '혼자 고민하지 마세요. 상담을 통해 마음의 짐을 덜어내세요.',
        '개개인의 문제에 맞춘 상담을 통해 최적의 해결책을 찾습니다.',
        '상담 초기 단계에서는 문제를 파악하고 목표를 설정합니다. 중기에는 감정표출과 문제 해결을 위한 접근을 시도합니다.');

-- spec_tb
INSERT INTO spec_tb (spec_type, details, user_id)
VALUES
    -- Expert 1 (홍길동)
    ('CAREER', '어바웃미 선정, 10월의 전문가', 21),
    ('CAREER', '사회복지사 2급 (보건복지부)', 21),
    ('CAREER', '미술치료사 2급 (국제민간자격증문협회)', 21),
    ('CAREER', '자살예방교육전문강사 (한국자살예방센터)', 21),
    ('CAREER', '전문 심리상담경력 (11년 5개월)', 21),
    ('CAREER', '현 마음숲 심리상담센터 센터장', 21),
    ('CAREER', '현 집단상담전문가', 21),
    ('CAREER', '전 대구극동방송국 상담사', 21),
    ('CAREER', '전 대구동구청소년동반자', 21),
    ('EDUCATION', '계명대학교대학원 가족상담학 석사 졸업', 21),

    -- Expert 2 (이영희)
    ('CAREER', '전문상담사 2급 (한국상담학회)', 22),
    ('CAREER', '교정상담사 2급 (교정상담학회)', 22),
    ('CAREER', '기업상담전문가 2급 (한국가족문화상담협회)', 22),
    ('CAREER', 'PTSD심리상담사 2급 (한국심리훈련연구소)', 22),
    ('CAREER', '현 어바웃미 심리상담사', 22),
    ('CAREER', '현 경북대학교병원 사내상담사', 22),
    ('CAREER', '현 한국철도청 MOU 및 전문상담사', 22),
    ('CAREER', '전 동대구초등학교 워크클래스 상담사', 22),
    ('EDUCATION', '연세대학교 졸업', 22),

    -- Expert 3 (박철수)
    ('CAREER', '심리상담사 1급 자격증 소지 (한국심리학회)', 23),
    ('CAREER', '전문 상담경력 (15년)', 23),
    ('CAREER', '현 마음클리닉 소장', 23),
    ('CAREER', '전 서울대학교병원 심리상담사', 23),
    ('EDUCATION', '서울대학교 심리학과 박사 졸업', 23),

    -- Expert 4 (김미영)
    ('CAREER', '미술치료사 1급 자격증 소지 (한국미술치료학회)', 24),
    ('CAREER', '아동 심리상담 경력 (10년)', 24),
    ('CAREER', '현 아동심리센터 원장', 24),
    ('CAREER', '전 연세대학교병원 소아심리상담사', 24),
    ('EDUCATION', '연세대학교 아동심리학 석사 졸업', 24),

    -- Expert 5 (이종현)
    ('CAREER', '가족상담사 1급 자격증 소지 (한국가족상담학회)', 25),
    ('CAREER', '가족 및 부부상담 경력 (12년)', 25),
    ('CAREER', '현 가족상담클리닉 소장', 25),
    ('CAREER', '전 중앙대학교병원 가족상담사', 25),
    ('EDUCATION', '중앙대학교 가족상담학 석사 졸업', 25),

    -- Expert 6 (윤정희)
    ('CAREER', '학교상담사 1급 자격증 소지 (한국학교상담학회)', 26),
    ('CAREER', '청소년 상담 경력 (13년)', 26),
    ('CAREER', '현 청소년상담센터 소장', 26),
    ('CAREER', '전 고려대학교병원 청소년상담사', 26),
    ('EDUCATION', '고려대학교 교육심리학 석사 졸업', 26),

    -- Expert 7 (최현우)
    ('CAREER', '부부상담사 1급 자격증 소지 (한국부부상담학회)', 27),
    ('CAREER', '부부 및 커플 상담 경력 (14년)', 27),
    ('CAREER', '현 부부상담클리닉 소장', 27),
    ('CAREER', '전 성균관대학교병원 부부상담사', 27),
    ('EDUCATION', '성균관대학교 부부상담학 석사 졸업', 27),

    -- Expert 8 (김소정)
    ('CAREER', '임상심리사 1급 자격증 소지 (한국임상심리학회)', 28),
    ('CAREER', '임상심리 경력 (16년)', 28),
    ('CAREER', '현 임상심리연구소 소장', 28),
    ('CAREER', '전 한양대학교병원 임상심리사', 28),
    ('EDUCATION', '한양대학교 임상심리학 석사 졸업', 28),

    -- Expert 9 (박재호)
    ('CAREER', '정신건강상담사 1급 자격증 소지 (한국정신건강상담학회)', 29),
    ('CAREER', '정신건강 상담 경력 (18년)', 29),
    ('CAREER', '현 정신건강센터 소장', 29),
    ('CAREER', '전 경희대학교병원 정신건강상담사', 29),
    ('EDUCATION', '경희대학교 정신건강학 석사 졸업', 29),

    -- Expert 10 (이유리)
    ('CAREER', '놀이치료사 1급 자격증 소지 (한국놀이치료학회)', 30),
    ('CAREER', '놀이치료 경력 (11년)', 30),
    ('CAREER', '현 놀이치료센터 소장', 30),
    ('CAREER', '전 이화여자대학교병원 놀이치료사', 30),
    ('EDUCATION', '이화여자대학교 놀이치료학 석사 졸업', 30);

--
-- 상담 데이터
INSERT INTO counsel_tb (client_id, expert_id, voucher_id, result, counsel_date, created_at, updated_at)
VALUES
    (12, 21, 1, '상담을 통해 문제의 원인을 분석했습니다.', NOW(), NOW(), NOW()),
    (13, 21, 2, '상담을 통해 문제의 원인을 분석했습니다.', NOW(), NOW(), NOW()),
    (14, 21, 3, '상담을 통해 문제의 원인을 분석했습니다.', NOW(), NOW(), NOW()),
    (3, 22, 4, '내담자의 감정 조절 방법을 논의했습니다.', NOW(), NOW(), NOW()),
    (4, 23, 5, '상담을 통해 스트레스 관리 전략을 제안했습니다.', NOW(), NOW(), NOW()),
    (5, 24, 6, '내담자의 목표 설정에 대한 조언을 제공했습니다.', NOW(), NOW(), NOW()),
    (6, 25, 7, '상담을 통해 문제 해결의 접근 방법을 논의했습니다.', NOW(), NOW(), NOW()),
    (7, 26, 8, '내담자의 자존감 향상 방안을 제안했습니다.', NOW(), NOW(), NOW()),
    (8, 27, 9, '내담자의 불안 완화 기법을 설명했습니다.', NOW(), NOW(), NOW()),
    (9, 28, 10, '상담을 통해 의사소통 기술을 향상시켰습니다.', NOW(), NOW(), NOW()),
    (10, 29, 11, '내담자의 동기 부여를 위한 전략을 논의했습니다.', NOW(), NOW(), NOW()),
    (11, 30, 12, '내담자의 경력 개발 방안을 제안했습니다.', NOW(), NOW(), NOW());

-- 리뷰 데이터
INSERT INTO review_tb (user_id, counsel_id, content, created_at, updated_at)
VALUES
    (12, 1, '상담사와의 대화가 많은 도움이 되었고, 문제의 원인을 알 수 있었습니다.나나나나나', NOW(), NOW()),
    (13, 2, '상담사와의 대화가 많은 도움이 되었고, 문제의 원인을 알 수 있었습니다.다다다다다', NOW(), NOW()),
    (14, 3, '상담사와의 대화가 많은 도움이 되었고, 문제의 원인을 알 수 있었습니다.가가가가가', NOW(), NOW()),
    (3, 4, '감정 조절 방법에 대해 상담사에게 배울 수 있어 유익했습니다.', NOW(), NOW()),
    (4, 5, '스트레스 관리에 대한 좋은 전략을 얻었습니다.', NOW(), NOW()),
    (5, 6, '목표 설정에 대한 상담사의 조언이 매우 도움이 되었습니다.', NOW(), NOW()),
    (6, 7, '문제 해결 방법에 대해 유용한 정보를 얻었습니다.', NOW(), NOW()),
    (7, 8, '자존감 향상에 대한 좋은 방법을 배웠습니다.', NOW(), NOW()),
    (8, 9, '불안을 다루는 기법에 대해 많은 도움이 되었습니다.', NOW(), NOW()),
    (9, 10, '의사소통 기술을 향상시키는 데 유익한 상담이었습니다.', NOW(), NOW()),
    (10, 11, '동기 부여를 위한 좋은 전략을 제안받았습니다.', NOW(), NOW()),
    (11, 12, '경력 개발에 대한 유용한 조언을 얻었습니다.', NOW(), NOW());



