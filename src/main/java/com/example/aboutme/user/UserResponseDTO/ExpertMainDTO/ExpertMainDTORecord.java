package com.example.aboutme.user.UserResponseDTO.ExpertMainDTO;

import java.util.List;

public record ExpertMainDTORecord(
        List<ReviewRecord> reviews,
        List<CounselRecord> counsels
) {
}
