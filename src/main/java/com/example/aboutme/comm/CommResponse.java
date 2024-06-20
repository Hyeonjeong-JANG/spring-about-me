package com.example.aboutme.comm;

import com.example.aboutme.comm.enums.CommCategory;
import com.example.aboutme.reply.Reply;
import com.example.aboutme.user.User;
import lombok.Builder;
import lombok.Data;

public class CommResponse {

    @Data
    public static class CommDTO {
        private String title;
        private CommCategory category;
        private String profileImage;
        private String name;
        private String content;
        private Integer heartCount;
        private Integer replyCount;

        @Builder
        public CommDTO(String title, CommCategory category, String profileImage, String name, String content, Integer heartCount, Integer replyCount) {
            this.title = title;
            this.category = category;
            this.profileImage = profileImage;
            this.name = name;
            this.content = content;
            this.heartCount = heartCount;
            this.replyCount = replyCount;
        }
    }


    @Data
    public static class ClientMainCommListDTO {
        private Integer communityId;
        private String title;
        private String content;
        private String category;
        private String writerImage;
        private String writerName;
        private String expertImage;
        private String expertName;

    }
}
