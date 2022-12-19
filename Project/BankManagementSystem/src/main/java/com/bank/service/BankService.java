package com.bank.service;

import java.util.List;

import com.bank.entity.Bank;
import com.bank.model.BankDto;



public interface BankService {

	//Abstract methods
	
	String createBank(Bank bank);
	BankDto updateBank(int id,Bank Bank);
	BankDto getBank(int id);	
	List<BankDto> getAllBank();
	String deleteBank(int id);
	void deleteAllBank();
	List<BankDto> getBankByName(String bankName);
	List<BankDto> getBankByBranchName(String branchName);
	List<BankDto> getBankbyBranchLocation(String branchLocation);

	
}
