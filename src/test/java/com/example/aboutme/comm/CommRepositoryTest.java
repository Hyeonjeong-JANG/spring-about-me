package com.example.aboutme.comm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommRepositoryTest {
    @Autowired
    private CommRepository commRepository;

    @Test
    void findAllCommDTOs() {
        List<CommResponse.CommDTO> commDTOS = commRepository.findAllCommDTOs();
        commDTOS.forEach(commDTO -> System.out.println("commDTO = " + commDTO));
    }
}