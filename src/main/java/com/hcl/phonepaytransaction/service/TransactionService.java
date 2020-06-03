package com.hcl.phonepaytransaction.service;

import org.json.JSONException;

import com.hcl.phonepaytransaction.dto.TransferDto;
import com.hcl.phonepaytransaction.model.Transaction;

public interface TransactionService {

	public Transaction fundTransfer(TransferDto dto,int userId)  throws JSONException;
}
