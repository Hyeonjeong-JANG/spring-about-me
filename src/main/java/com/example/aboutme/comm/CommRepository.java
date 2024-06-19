package com.example.aboutme.comm;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommRepository extends JpaRepository<Comm, Integer> {

//    @Query("""
//            SELECT new com.example.aboutme.comm.CommResponse.ClientMainCommListDTO(
//            c.id,
//            c.title,
//            c.content,
//            c.category,
//            c.user.profileImage,
//            c.user.name,
//            r.user.profileImage,
//            r.user.name
//            )
//            FROM Comm c
//            JOIN c.replies r
//            WHERE r.user.userRole = com.example.aboutme.user.enums.UserRole.EXPERT
//                    """)
//    List<CommResponse.ClientMainCommListDTO> findCommsWithReply();

        @Query("SELECT new com.example.aboutme.comm.CommResponse$CommDTO(" +
                "c.title, c.category, u.profileImage, u.name, c.content, " +
                "SIZE(c.replies), " +  // This is a placeholder for heartCount
                "SIZE(c.replies)) " +  // Assuming replyCount is the size of replies
                "FROM Comm c " +
                "JOIN c.user u")
        List<CommResponse.CommDTO> findAllCommDTOs();
}
