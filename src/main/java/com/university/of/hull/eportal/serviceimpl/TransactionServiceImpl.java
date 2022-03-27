package com.university.of.hull.eportal.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.of.hull.eportal.dataentity.Clubs;
import com.university.of.hull.eportal.dataentity.Transactions;
import com.university.of.hull.eportal.dataentity.Users;
import com.university.of.hull.eportal.datamodel.transaction.FetchTransactionResponse;
import com.university.of.hull.eportal.datamodel.transaction.TransactionRequest;
import com.university.of.hull.eportal.datamodel.transaction.TransactionResponse;
import com.university.of.hull.eportal.repository.ClubRepository;
import com.university.of.hull.eportal.repository.TransactionRepository;
import com.university.of.hull.eportal.repository.UsersRepository;
import com.university.of.hull.eportal.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public TransactionResponse makeTransaction(TransactionRequest transactionRequest) {
		TransactionResponse transactionResponse = new TransactionResponse();

		Transactions transactions = new Transactions();
		transactions.setClubId(transactionRequest.getClubId());
		transactions.setUserId(transactionRequest.getUserId());
		transactions.setTransactionAmount(transactionRequest.getTransactionAmount());
		transactions.setTransactionStatus(transactionRequest.getTransactionStatus());
		transactions.setLastFourCardDigits(transactionRequest.getLastFourCardDigits());
		transactions.setTransactionDate(new Timestamp(System.currentTimeMillis()));

		Transactions trans = transactionRepository.save(transactions);
		if (null != trans) {
			transactionResponse.setMessage("Transaction record entered successfully");
		} else {
			transactionResponse.setMessage("Failed to enter transaction record, Please try again later.");
			throw new RuntimeException("Failed to enter transaction record, Please try again later.");
		}
		return transactionResponse;
	}

	@Override
	public FetchTransactionResponse fetchTransactionByUserId(Long userId) {
		FetchTransactionResponse fetchTransactionResponse = new FetchTransactionResponse();
		Users user = usersRepository.findByUserId(userId);
		if (user != null) {
			List<Transactions> transactions = transactionRepository.FindByUserId(userId);
			if (!transactions.isEmpty()) {
				List<TransactionRequest> transList = new ArrayList<TransactionRequest>();
				for(Transactions trans: transactions) {
					TransactionRequest transaction = new TransactionRequest();
					transaction.setClubId(trans.getClubId());
					transaction.setUserId(trans.getUserId());
					transaction.setLastFourCardDigits(trans.getLastFourCardDigits());
					transaction.setTransactionAmount(trans.getTransactionAmount());
					transaction.setTransactionStatus(trans.getTransactionStatus());
					transaction.setTransactionId(trans.getTransactionId());
					transList.add(transaction);
				}
				fetchTransactionResponse.setTransactions(transList);
				fetchTransactionResponse.setMessage("Transaction records fetched successfully.");
			} else {
				fetchTransactionResponse.setMessage("No records found.");
				throw new RuntimeException("No records found.");
			}

		} else {
			fetchTransactionResponse.setMessage("User does not exists, Please supply proper user id");
			throw new RuntimeException("User does not exists, Please supply proper user id");
		}
		return fetchTransactionResponse;
	}

	@Override
	public FetchTransactionResponse fetchTransactionByClubId(String clubId) {
		FetchTransactionResponse fetchTransactionResponse = new FetchTransactionResponse();
		Clubs club = clubRepository.findByClubId(clubId);
		if (club != null) {
			List<Transactions> transactions = transactionRepository.FindByClubId(clubId);
			if (!transactions.isEmpty()) {
				List<TransactionRequest> transList = new ArrayList<TransactionRequest>();
				for(Transactions trans: transactions) {
					TransactionRequest transaction = new TransactionRequest();
					transaction.setClubId(trans.getClubId());
					transaction.setUserId(trans.getUserId());
					transaction.setLastFourCardDigits(trans.getLastFourCardDigits());
					transaction.setTransactionAmount(trans.getTransactionAmount());
					transaction.setTransactionStatus(trans.getTransactionStatus());
					transaction.setTransactionId(trans.getTransactionId());
					transList.add(transaction);
				}
				fetchTransactionResponse.setTransactions(transList);
				fetchTransactionResponse.setMessage("Transaction records fetched successfully.");
			} else {
				fetchTransactionResponse.setMessage("No records found.");
				throw new RuntimeException("No records found.");
			}

		} else {
			fetchTransactionResponse.setMessage("Club does not exists, Please supply proper club id");
			throw new RuntimeException("Club does not exists, Please supply proper club id");
		}
		return fetchTransactionResponse;
	}

}
