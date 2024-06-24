package com.example.aboutme.comm;

import com.example.aboutme.comm.enums.CommCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CommServiceTest {
    @Autowired
    private CommRepository commRepository;

    @Test
    void findByCatagory() {
        CommCategory category = CommCategory.GENERAL_CONCERNS;
        List<Comm> comms = commRepository.findByCategory(category);
        comms.forEach(comm -> System.out.println("comm = " + comm));
    }


    @Test
    void getCommDetail() {
        int id = 1;
        CommCategory category = CommCategory.GENERAL_CONCERNS;
        List<Comm> comms = commRepository.findByCategoryWithRepliesAndExcludeId(category, 1);
        comms.forEach(comm -> {
            System.out.println("comm = " + comm);
            if (comm.getReplies() != null) {
                comm.getReplies().forEach(reply -> System.out.println("reply = " + reply));
            } else {
                System.out.println("No replies found for comm id " + comm.getId());
            }
        });
    }
}