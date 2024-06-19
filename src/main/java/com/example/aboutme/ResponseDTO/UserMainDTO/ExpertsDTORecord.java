package com.example.aboutme.ResponseDTO.UserMainDTO;

public record ExpertsDTORecord(
        Integer expertId,
        String expertImage,
        String expertTitle,
        Boolean hasCenter,
        Boolean hasTextTherapy,
        Boolean hasVoiceTherapy,
        Boolean hasVideoTherapy) {
}
