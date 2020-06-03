package com.hcl.phonepaytransaction.controller;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.phonepaytransaction.dao.UserRepository;
import com.hcl.phonepaytransaction.dto.TransferDto;
import com.hcl.phonepaytransaction.model.Transaction;
import com.hcl.phonepaytransaction.model.User;
import com.hcl.phonepaytransaction.service.TransactionServiceImpl;
@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {
	private static final int userId = 0;

	@InjectMocks
	TransactionControllerTest transactionController;
	
	@Mock
	TransactionServiceImpl busBookingService;
	@Mock
	UserRepository userRepositroy;
	static Transaction transction=null;
	@BeforeClass
	public static void setUp() {
		transction=new Transaction();
		transction.setFromMobileNumber(90104714);
		transction.setToMobileNumber(88989);
		transction.setTransactionId(8989);
	}
	@Test
	public void testcreateBuspositiveNegtive() throws JSONException {
		TransferDto dto=new TransferDto();
		
		User user=new User();

		Mockito.when(userRepositroy.getOne(user.getUserId())).thenReturn(user);

		Mockito.when(busBookingService.fundTransfer(dto, userId)).thenReturn(transction);

	}

}
