package com.university.of.hull.eportal.datamodel.events;

import com.university.of.hull.eportal.extradata.PaymentStatus;

public class JoinEventRequest {

	 private long eventId;

	    private long userId;

	    private String clubId;

	    private PaymentStatus paymentStatus;

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

}
