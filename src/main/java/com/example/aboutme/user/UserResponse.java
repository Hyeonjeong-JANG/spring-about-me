package com.example.aboutme.user;

import lombok.Data;

import java.util.List;

public class UserResponse {


    // 상담사 리스트DTO
    @Data
    public static class ExpertUserDTO {
        public Integer expertId;
        public String name;
        public String title;
        public List<VoucherImageDTO> voucherImage;
        public String profileImage;

        public ExpertUserDTO(User user, List<VoucherImageDTO> voucherImage) {
            this.expertId = user.getId();
            this.name = user.getName();
            this.title = user.getExpertTitle();
            this.voucherImage = voucherImage;
            this.profileImage = user.getProfileImage();
        }

        @Data
        public static class VoucherImageDTO {
            public String url;

            public VoucherImageDTO(String url) {
                this.url = url;
            }
        }
    }

//    @Data
//    public static class ClientMainCommListDTO {
//        private Integer communityId;
//        private String title;
//        private String content;
//        private String category;
//        private String writerImage;
//        private String writerName;
//        private String expertImage;
//        private String expertName;
//
//        public ClientMainCommListDTO(Integer communityId, String title, String content, CommCategory category,
//                                     String writerImage, String writerName, String expertImage, String expertName) {
//            this.communityId = communityId;
//            this.title = title;
//            this.content = content;
//            this.category = category.getKorean();
//            this.writerImage = writerImage;
//            this.writerName = writerName;
//            this.expertImage = expertImage;
//            this.expertName = expertName;
//        }
//    }
}
