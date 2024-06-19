package com.example.aboutme.user;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    // 메인 커뮤니티 리스트
//    @Query("""
//            SELECT new com.example.aboutme.comm.UserResponse$ClientMainCommListDTO(
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
//    List<UserResponse.ClientMainCommListDTO> findCommsWithReply();
}
