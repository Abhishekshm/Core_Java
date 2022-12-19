package com.bank.service;

import java.util.List;

import com.bank.entity.Account;
import com.bank.model.AccountDto;


public interface AccountService {

	//Absract Method
	String createAccount(Account account);
	AccountDto updateAccount(int id,Account account);
	AccountDto getAccount(int id);	
	List<AccountDto> getAllAccount();
	String deleteAccount(int id);
	void deleteAllAccount();
	AccountDto assignAccountToBankId(int id,int bankId);
	String deposit(int accountNo,int pin ,double amount);
	String withdrawl(int accountNo ,int pin, double amount);
	String checkBalance(int accountNo);
	String transferMoney(int firstAccountNo,int secondAccountNo,int pin,double amount);
	List<AccountDto> getAccountByName(String accountName);
	List<AccountDto> getAccountByType(String accountType);
	List<AccountDto> getAccountByPhoneNo(long phoneNo);
	List<AccountDto> getAccountByBank(int bankId);
} 
