package com.university.of.hull.eportal.datamodel.transaction;

import java.util.List;

import com.university.of.hull.eportal.datamodel.Message;

public class FetchTransactionResponse extends Message {

	private List<TransactionRequest> transactions;

	public List<TransactionRequest> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionRequest> transactions) {
		this.transactions = transactions;
	}
}
