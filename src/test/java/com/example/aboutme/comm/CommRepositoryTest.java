package com.example.aboutme.comm;

import com.example.aboutme.comm.enums.CommCategory;
import com.example.aboutme.reply.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CommRepositoryTest {
    @Autowired
    private CommRepository commRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void findCommsAndRepliesByCategory() {
        CommCategory category = CommCategory.GENERAL_CONCERNS;

        // 글 조회
    }
}