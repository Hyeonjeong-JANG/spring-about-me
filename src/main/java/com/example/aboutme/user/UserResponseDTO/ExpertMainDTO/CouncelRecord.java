package com.example.aboutme.user.UserResponseDTO.ExpertMainDTO;

import com.example.aboutme.voucher.enums.VoucherType;

public record CouncelRecord(
        Integer id,
        String counselDate,
        String clientName,
        VoucherType voucherType,
        Integer duration
) {
}
