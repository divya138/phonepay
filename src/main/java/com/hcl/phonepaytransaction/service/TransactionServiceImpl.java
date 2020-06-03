package com.hcl.phonepaytransaction.service;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.hcl.phonepaytransaction.dao.TransactionRepository;
import com.hcl.phonepaytransaction.dao.UserRepository;
import com.hcl.phonepaytransaction.dto.TransferDto;
import com.hcl.phonepaytransaction.model.Transaction;
import com.hcl.phonepaytransaction.model.User;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	RestTemplate template;
	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction fundTransfer(TransferDto dto, int userId) throws JSONException {

		User user = userRepository.getOne(userId);

		String uri = "http://localhost:9094/transaction";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("fromMobileNumber", dto.getFromMobileNumber());
		request.put("toMobileNumber", dto.getToMobileNumber());
		request.put("transferAmmount", dto.getAmmount());
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		template.postForEntity(uri, entity, Transaction.class);
		Transaction transaction = new Transaction(new Date(), dto.getAmmount(), dto.getFromMobileNumber(), user,
				dto.getToMobileNumber(), "transaction done successfully");
		transaction = transactionRepository.save(transaction);
		return transaction;
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
