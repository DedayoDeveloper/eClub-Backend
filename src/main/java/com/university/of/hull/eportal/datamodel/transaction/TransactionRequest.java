package com.university.of.hull.eportal.datamodel.transaction;

import com.university.of.hull.eportal.datamodel.Message;
import com.university.of.hull.eportal.extradata.TransactionStatus;

public class TransactionRequest {
	
	private Long transactionId;
	
	private String clubId;

	private Long userId;

	private String lastFourCardDigits;
	
	private Long transactionAmount;

	private TransactionStatus transactionStatus;

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLastFourCardDigits() {
		return lastFourCardDigits;
	}

	public void setLastFourCardDigits(String lastFourCardDigits) {
		this.lastFourCardDigits = lastFourCardDigits;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
}
