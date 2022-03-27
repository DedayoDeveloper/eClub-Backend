package com.university.of.hull.eportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.university.of.hull.eportal.dataentity.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer> {

	Events findByEventId(Long eventId);

	@Query(value = "SELECT * FROM e_portal_events event where event.club_id = ?1", nativeQuery = true)
	List<Events> findByClubId(String clubId);

	List<Events> findByClubIdLike(String clubId);

}
