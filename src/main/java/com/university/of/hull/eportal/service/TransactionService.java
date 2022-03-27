package com.university.of.hull.eportal.service;

import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;
import com.university.of.hull.eportal.datamodel.transaction.FetchTransactionResponse;
import com.university.of.hull.eportal.datamodel.transaction.TransactionRequest;
import com.university.of.hull.eportal.datamodel.transaction.TransactionResponse;

public interface TransactionService {

	TransactionResponse makeTransaction(TransactionRequest transactionRequest);

	FetchTransactionResponse fetchTransactionByUserId(Long userId);

	FetchTransactionResponse fetchTransactionByClubId(String clubId);

}
