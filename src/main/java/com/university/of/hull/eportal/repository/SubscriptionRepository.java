package com.university.of.hull.eportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.of.hull.eportal.dataentity.Subscription;

public interface SubscriptionRepository  extends JpaRepository<Subscription, Integer>{

	Subscription findByUserId(long userId);

}
