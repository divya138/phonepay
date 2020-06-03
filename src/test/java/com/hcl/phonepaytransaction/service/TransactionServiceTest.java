package com.hcl.phonepaytransaction.service;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner.Silent;

import com.hcl.phonepaytransaction.dao.TransactionRepository;
import com.hcl.phonepaytransaction.dao.UserRepository;
import com.hcl.phonepaytransaction.dto.TransferDto;
import com.hcl.phonepaytransaction.model.Transaction;
import com.hcl.phonepaytransaction.model.User;

@RunWith(Silent.class)
public class TransactionServiceTest {
	private static final int userId = 0;

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;

	@Mock
	TransactionRepository transactionRepository;
	@Mock
	UserRepository userRepositroy;
	static Transaction transction=null;
	TransferDto dto=new TransferDto();
	@BeforeClass
	public static void setUp() {
		transction=new Transaction();
		transction.setFromMobileNumber(90104714);
		transction.setToMobileNumber(88989);
		transction.setTransactionId(8989);
	}
	
	@Test(expected = NullPointerException.class)
	public void transferForPositive() throws JSONException{
		Transaction transaction=new Transaction();
		User user=new User();
		Mockito.when(userRepositroy.getOne(user.getUserId())).thenReturn(user);
		Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);
		Assert.assertEquals(transaction, transactionServiceImpl.fundTransfer(dto, userId));
		
	}
	@Test(expected = NullPointerException.class)
	public void transferForNegative() throws JSONException {
		Transaction transaction=new Transaction();
		TransferDto  dto=new TransferDto();
		Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);
		Assert.assertEquals(transaction, transactionServiceImpl.fundTransfer(dto, 1));
	}

}
