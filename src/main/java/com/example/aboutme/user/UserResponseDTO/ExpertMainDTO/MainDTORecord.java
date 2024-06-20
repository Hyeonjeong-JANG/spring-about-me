package com.example.aboutme.user.UserResponseDTO.ExpertMainDTO;

import java.util.List;

public record MainDTORecord(
        List<ReviewRecord> reviews,
        List<CouncelRecord> counsels
) {
}
