package com.university.of.hull.eportal.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.of.hull.eportal.datamodel.ApiResponse;
import com.university.of.hull.eportal.datamodel.transaction.FetchTransactionResponse;
import com.university.of.hull.eportal.datamodel.transaction.TransactionRequest;
import com.university.of.hull.eportal.datamodel.transaction.TransactionResponse;
import com.university.of.hull.eportal.service.TransactionService;

@RestController
@RequestMapping(value = "/e-portal")
public class TransctionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping(value = "/maketransaction")
	public ApiResponse<String> makeTransaction(@RequestBody TransactionRequest transactionRequest){
		ApiResponse<String> apiResponse = new ApiResponse<>();
		TransactionResponse transactionResponse = transactionService.makeTransaction(transactionRequest);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(transactionResponse.getMessage());
		return apiResponse;
	}
	
	@GetMapping(value = "/fetchtransactionbyuserid")
	public ApiResponse<FetchTransactionResponse> fetchTransactionByUserId(@RequestParam(name = "userId") Long userId){
		ApiResponse<FetchTransactionResponse> apiResponse = new ApiResponse<>();
		FetchTransactionResponse fetchTransactionResponse = transactionService.fetchTransactionByUserId(userId);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(fetchTransactionResponse);
		return apiResponse;
	}
	
	@GetMapping(value = "/fetchtransactionbyclubid")
	public ApiResponse<FetchTransactionResponse> fetchTransactionByClubId(@RequestParam(name = "clubId") String clubId){
		ApiResponse<FetchTransactionResponse> apiResponse = new ApiResponse<>();
		FetchTransactionResponse fetchTransactionResponse = transactionService.fetchTransactionByClubId(clubId);
		apiResponse.setMessage("Success");
		apiResponse.setResponsecode("00");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setResponse(fetchTransactionResponse);
		return apiResponse;
	}

}
