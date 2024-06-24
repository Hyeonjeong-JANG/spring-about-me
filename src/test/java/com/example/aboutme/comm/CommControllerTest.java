package com.example.aboutme.comm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommControllerTest {
    @Autowired
    private CommService commService;

    @Test
    void detail() throws JsonProcessingException {
        int id = 1;
        CommResponse.CommDetailDTO commDetailDTO = commService.getCommDetail(id);
        String json = new ObjectMapper().writeValueAsString(commDetailDTO);
        System.out.println("json = " + json);
    }
}