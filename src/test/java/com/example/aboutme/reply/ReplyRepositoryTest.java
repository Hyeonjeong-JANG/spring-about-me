package com.example.aboutme.reply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void findByCommId() {

        List<Reply> reply = replyRepository.findByCommId(1);
        reply.stream().forEach(reply1 -> System.out.println("reply = " + reply1));
    }
}