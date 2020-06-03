package com.hcl.phonepaytransaction.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.phonepaytransaction.dto.TransferDto;
import com.hcl.phonepaytransaction.model.Transaction;
import com.hcl.phonepaytransaction.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/transfer/{userId}")
	public ResponseEntity<Transaction> transactionForPhon(@RequestBody TransferDto dto, @PathVariable int userId)
			throws JSONException {
		Transaction transaction = transactionService.fundTransfer(dto, userId);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);

	}

}
