package com.university.of.hull.eportal.repository;


import com.university.of.hull.eportal.extradata.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.university.of.hull.eportal.dataentity.Clubs;

@Repository
public interface ClubRepository extends JpaRepository<Clubs, Integer>{

    Clubs findByClubId(String cludId);
    
    Clubs findByClubEmail(String email);

    @Query("select c.clubStatus from Clubs c where c.clubEmail = :email")
    Status getUserStatus(@Param("email") String email);

	List<Clubs> findByClubStatusIs(Status clubStatus);
}
