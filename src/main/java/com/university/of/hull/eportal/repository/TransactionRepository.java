package com.university.of.hull.eportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.university.of.hull.eportal.dataentity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

	@Query(value = "SELECT * FROM e_portal_transaction t where t.club_id = ?1", nativeQuery = true)
	List<Transactions> FindByClubId(String clubId);

	@Query(value = "SELECT * FROM e_portal_transaction t where t.user_id = ?1", nativeQuery = true)
	List<Transactions> FindByUserId(Long userId);

}
