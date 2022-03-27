package com.university.of.hull.eportal.dataentity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.university.of.hull.eportal.extradata.TransactionStatus;

@Entity
@Table(name = "e_portal_transaction")
public class Transactions implements Serializable{

private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long transactionId;
    
    @Column(name = "club_id")
    private String clubId;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "last_four_card_digits")
    private String lastFourCardDigits;
    
    @Column(name = "transaction_amount")
    private Long transactionAmount;
    
    @Column(name = "transaction_status")
    private TransactionStatus transactionStatus;
    
    @Column(name = "transaction_date")
    private Timestamp transactionDate;
    
    public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

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

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
    
}
