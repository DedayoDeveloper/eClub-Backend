package com.university.of.hull.eportal.repository;

import com.university.of.hull.eportal.extradata.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.university.of.hull.eportal.dataentity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

   Users findByEmailAddress(String email);

   @Query("select u.userStatus from Users u where u.emailAddress = :email")
   Status getUserStatus(@Param("email") String email);

	Users findByUserId(Long userId);
	
}
