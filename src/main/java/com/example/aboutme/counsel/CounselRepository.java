package com.example.aboutme.counsel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CounselRepository extends JpaRepository<Counsel, Integer> {
    //    @Query("""
//SELECT c
//FROM Counsel c
//JOIN FETCH c.expert.id =
//""")
    Collection<Object> findByExpertId(Integer expertId);
}
