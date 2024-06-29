package com.example.aboutme.user.UserResponseRecord.ExpertFindDetailDTO;

import java.util.List;

// Main record for detailed expert information
public record DetailDTORecord(
        UserRecord user,
        String lowestPrice,
        List<ReviewRecord> reviews,
        List<PRRecord> prs,
        List<SpecRecord> careerSpecs,
        List<SpecRecord> educationSpecs,
        String reviewSummary
) {
}

