package com.example.aboutme.ResponseDTO.UserMainDTO;

import java.util.List;

public record UserMainDTORecord(
        List<CommsDTORecord> comms,
        List<ExpertsDTORecord> experts
) {
}
