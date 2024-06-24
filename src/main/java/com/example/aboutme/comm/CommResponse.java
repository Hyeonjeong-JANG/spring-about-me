package com.example.aboutme.comm;

import com.example.aboutme.comm.enums.CommCategory;
import com.example.aboutme.reply.Reply;
import com.example.aboutme.user.enums.UserRole;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CommResponse {

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

        public ClientMainCommListDTO(Integer communityId, String title, String content, CommCategory category,
                                     String writerImage, String writerName, String expertImage, String expertName) {
            this.communityId = communityId;
            this.title = title;
            this.content = content;
            this.category = category.getKorean();
            this.writerImage = writerImage;
            this.writerName = writerName;
            this.expertImage = expertImage;
            this.expertName = expertName;
        }
    }

    @Data
    public static class CommAndReplyDTO {
        private Integer id;
        private String title;
        private String content;
        private String category;
        private String userProfileImage;
        private String writerName;
        private boolean userRole;
        private String replyProfileImage;
        private String expertName;
        private String solution;

        // 생성자 잘 확인해야함. EXPERT면 true 나와서 출력할 수 있도록.
        public CommAndReplyDTO(Integer id, String title, String content, CommCategory category, String userProfileImage, String writerName,
                               UserRole userRole, String replyProfileImage, String expertName, String solution) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.category = category.getKorean();
            this.userProfileImage = userProfileImage;
            this.writerName = writerName;
            this.userRole = userRole == UserRole.EXPERT ? true : false;
            this.replyProfileImage = replyProfileImage;
            this.expertName = expertName;
            this.solution = solution;
        }
    }
//    @Data
//    public static class CommDetailDTO {
//
//        private List<String> replyContents;
//        private List<String> replyContents;
//        private Map<String, List<CommDTO>> commsByCategory;
//
//        public CommDetailDTO(Integer id, String clientImage, String name, String content, String title, String category, Timestamp createdAt, List<String> replyContents, Map<String, List<CommDTO>> commsByCategory) {
//            this.id = id;
//            this.clientImage = clientImage;
//            this.name = name;
//            this.content = content;
//            this.title = title;
//            this.category = category;
//            this.createdAt = createdAt;
//            this.replyContents = replyContents;
//            this.commsByCategory = commsByCategory;
//        }
//    }
//
//    @Data
//    public static class CommDTO {
//        private Integer id;
//        private String content;
//        private String title;
//        private String category;
//        private Timestamp createdAt;
//
//        public CommDTO(Integer id, String content, String title, String category, Timestamp createdAt) {
//            this.id = id;
//            this.content = content;
//            this.title = title;
//            this.category = category;
//            this.createdAt = createdAt;
//        }
//    }

    @Data
    public static class CommDetailDTO {
        private CommDTO commDTO;
        private List<ReplyDTO> replies = new ArrayList<>();
        private List<RelatedCommWithRepliesDTO> relatedComms = new ArrayList<>();

        public CommDetailDTO(Comm comm, List<Reply> replies, List<Comm> relatedComms) {
            this.commDTO = new CommDTO(comm);
            this.replies = replies.stream()
                    .map(ReplyDTO::new)
                    .toList();
            this.relatedComms = relatedComms.stream()
                    .map(RelatedCommWithRepliesDTO::new)
                    .toList();
        }

        @Data
        public static class CommDTO {
            private Integer id;
            private String title;
            private String content;
            private String category;
            private String writerName;
            private String writerProfileImage;
            private Timestamp createdAt;
            //            private int likeCount;
            private int replyCount;

            public CommDTO(Comm comm) {
                this.id = comm.getId();
                this.title = comm.getTitle();
                this.content = comm.getContent();
                this.category = comm.getCategory().getKorean();
                this.writerName = comm.getUser().getName();
                this.writerProfileImage = comm.getUser().getProfileImage();
                this.createdAt = comm.getCreatedAt();
//                this.likeCount = comm.getLikes().size();
                this.replyCount = comm.getReplies().size();
            }
        }

        @Data
        public static class ReplyDTO {
            private Integer id;
            private String content;
            private String solution;
            private Timestamp createdAt;

            public ReplyDTO(Reply reply) {
                this.id = reply.getId();
                this.content = reply.getContent();
                this.content = reply.getSolution();
                this.createdAt = reply.getCreatedAt();
            }
        }

        @Data
        public static class RelatedCommWithRepliesDTO {
            private Integer id;
            private String content;
            private String title;
            private String category;
            private Timestamp createdAt;
            private int replies;
            private List<ExpertReplyDTO> expertReplies = new ArrayList<>();

            public RelatedCommWithRepliesDTO(Comm comm) {
                this.id = comm.getId();
                this.content = comm.getContent();
                this.title = comm.getTitle();
                this.category = comm.getCategory().getKorean();
                this.createdAt = comm.getCreatedAt();
                this.replies = (int) comm.getReplies().stream()
                        .filter(reply -> !reply.getUser().getUserRole().equals(UserRole.CLIENT))
                        .count();
                this.expertReplies = comm.getReplies().stream()
                        .filter(reply -> reply.getUser().getUserRole().equals(UserRole.EXPERT))
                        .map(ExpertReplyDTO::new)
                        .collect(toList());
            }

            @Data
            public static class ExpertReplyDTO {
                private Integer id;
                private String solution;

                public ExpertReplyDTO(Reply reply) {
                    this.id = reply.getId();
                    this.solution = reply.getSolution();
                }
            }
        }
    }
}
