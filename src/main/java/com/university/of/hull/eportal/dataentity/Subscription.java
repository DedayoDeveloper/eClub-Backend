package com.university.of.hull.eportal.dataentity;

import com.university.of.hull.eportal.extradata.PaymentStatus;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "e_portal_subscriptions")
public class Subscription {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "event_id")
    private long eventId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "club_id")
    private String clubId;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Column(name = "subscription_date")
    private Timestamp subDate;
    
    public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Timestamp getSubDate() {
		return subDate;
	}

	public void setSubDate(Timestamp subDate) {
		this.subDate = subDate;
	}


}
