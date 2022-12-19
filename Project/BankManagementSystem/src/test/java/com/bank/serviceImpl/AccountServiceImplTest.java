package com.bank.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bank.entity.Account;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;

@SpringBootTest
public class AccountServiceImplTest {

	@Autowired
	private AccountService accountService;
	@MockBean
	private AccountRepository accountRepository;

	@DisplayName(value = "Create Account Possitve Test")
	@Test
	void createAccountTest() {
//		Account account= Account.builder().accountHolderName("Rahul").aadharNo(676473634).accountType("current").balance(5000)
//				.panNo("PAN8748374").phoneNo(98943743).setPin(9874).build();
		Account account = new Account();
		account.setAccountHolderName("Abhishek");
		account.setAadharNo(63736728);
		account.setAccountType("saving");
		account.setSetPin(1234);
		account.setBalance(2000);
		account.setPanNo("PAN1234545");
		account.setPhoneNo(883326452);
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		assertThat(accountService.createAccount(account)).isEqualTo("New Account is Open ..");
	}
	
	@Test
	void getAccount() {
		Account account= Account.builder().accountHolderName("Rahul").aadharNo(676473634).accountType("current").balance(5000)
		.panNo("PAN8748374").phoneNo(98943743).setPin(9874).build();
		Mockito.when(accountRepository.save(account)).thenReturn(account);
//		assertThat(accountService.getAccount(1)).isEqualTo(account);
		assertEquals(account.getAccountHolderName(), "Rahul");
	}
}
