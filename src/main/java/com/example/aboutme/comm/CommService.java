package com.example.aboutme.comm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommService {
    private final CommRepository commRepository;

        public List<CommResponse.CommDTO> printAllComm(){
            List<CommResponse.CommDTO> comms = commRepository.findAllCommDTOs();
            return comms;
        }

//    public List<CommResponse.ClientMainCommListDTO> getMainComms() {
//
//        return commRepository.findCommsWithReply();
//    }
}
